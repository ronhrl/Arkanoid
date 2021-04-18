import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class Line implements Sprite {
    private Point start;
    private Point end;
    private Color colorOfLine;

    /**
     * Constructor method of the object line.
     * @param start The start point of the line.
     * @param end The end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Additional constructor method.
     * @param x1 The x value of the start point of the line.
     * @param y1 The y value of the start point of the line.
     * @param x2 The x value of the end point of the line.
     * @param y2 The y value of the end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * This method calculates the length of a line.
     * this method uses the distance method from the class point to calculate the distance between two points.
     * @return The length of the line.
     */
    public double length() {
        return end.distance(start);
    }

    /**
     * This method calculates the x, and the y values of the middle point of the line and generates a new point.
     * @return The middle point of the line.
     */
    public Point middle() {
        double xMid, yMid;
        xMid = (this.start.getX() + this.end.getX()) / 2;
        yMid = (this.start.getY() + this.end.getY()) / 2;
        return new Point(xMid, yMid);
    }

    /**
     * This method gives the start point of the line.
     * @return The start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * This method gives the end point of the line.
     * @return The end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     *This method checks if the point p2 lies on the segment p1p3.
     * @param p1 The start point of the line.
     * @param p2 The point we want to check if it lies on the line p1p3.
     * @param p3 The end point of the line.
     * @return True if the point lies, otherwise false.
     */
    public boolean isOnSegment(Point p1, Point p2, Point p3) {
        return p2.getX() <= Math.max(p1.getX(), p3.getX()) && p2.getX() >= Math.min(p1.getX(), p3.getX())
                && p2.getY() <= Math.max(p1.getY(), p3.getY()) && p2.getY() >= Math.min(p1.getY(), p3.getY());
    }

    /**
     *This method finds the orientation of three points.
     * in order to know if two segments are intersect or not we must know.
     * if the three points are counterclockwise, clockwise, collinear.
     * @param p1 The first point we want to check.
     * @param p2 The second point we want to check.
     * @param p3 The third point we want to check.
     * @return 0 if they are collinear, 1 if they are clockwise, 2 ifs they are counterclockwise.
     */
    public int orientation(Point p1, Point p2, Point p3) {
        double orientVal = (p2.getY() - p1.getY()) * (p3.getX() - p2.getX())
                - ((p2.getX() - p1.getX()) * (p3.getY() - p2.getY()));
        if (orientVal == 0) {
            return 0;
        }
        if (orientVal > 0) {
            return 1;
        }
        return 2;
    }

    /**
     * This method checks if two segments are intersect or not.
     * the method uses the methods orientation and isOnSegment to check this.
     * @param other The other line we want check.
     * @return True if they are intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        int orient1, orient2, orient3, orient4;
        orient1 = orientation(this.start, this.end, other.start());
        orient2 = orientation(this.start, this.end, other.end());
        orient3 = orientation(other.start(), other.end(), this.start);
        orient4 = orientation(other.start(), other.end(), this.end);

       // this if condition checks the general case.

        if (orient1 != orient2 && orient3 != orient4) {
            return true;
        }

     //   those four if conditions checks all the special cases.

        if (orient1 == 0 && isOnSegment(this.start, other.start(), this.end)) {
            return true;
        }
        if (orient2 == 0 && isOnSegment(this.start, other.end(), this.end)) {
            return true;
        }
        if (orient3 == 0 && isOnSegment(other.start(), this.start, other.end())) {
            return true;
        }
        if (orient4 == 0 && isOnSegment(other.start(), this.end, other.end())) {
            return true;
        }
        return false;
    }

    /**
     * This method finds the intersection point.
     * @param other The other line we want to check.
     * @return If the lines are intersect it return intersection point if not it returns null.
     */
    public Point intersectionWith(Line other) {
        double a1, b1, c1, a2, b2, c2, determinant, interX, interY;
        a1 = other.start.getY() - other.end.getY();
        b1 = other.end.getX() - other.start.getX();
        c1 = a1 * (other.end.getX()) + b1 * (other.end.getY());
        a2 = this.start.getY() - this.end.getY();
        b2 = this.end.getX() - this.start.getX();
        c2 = a2 * (this.end.getX()) + b2 * (this.end.getY());
        if (!isIntersecting(other)) {
            return null;
        }
        determinant = a1 * b2 - a2 * b1;
        if (determinant == 0) {
            return null;
        } else {
            interX = (b2 * c1 - b1 * c2) / determinant;
            interY = (a1 * c2 - a2 * c1) / determinant;
            return new Point(interX, interY);
        }
    }

    /**
     * This method checks if two lines are the same.
     * @param other The other line we want to check.
     * @return True if they are same, false otherwise.
     */
    public boolean equal(Line other) {
        return other.start.getX() == this.start.getX() && other.start.getY() == this.start.getY()
                && other.end.getX() == this.end.getX() && other.end.getY() == this.end.getY();
    }

    /**
     * This method finds the closest intersection point between a line and a rectangle to the start of line.
     * @param rect The rectangle that we want the find its intersection point with the line.
     * @return The the closest point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        double dis1, dis2;
        Line line = new Line(this.start, this.end);
        List<Point> list = rect.intersectionPoints(line);
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
            dis1 = line.start().distance(list.get(0));
            dis2 = line.start().distance(list.get(1));
            if (dis1 < dis2) {
                return list.get(0);
        }
        return list.get(1);
    }

    /**
     * This method draw the sprite to the draw surface.
     *
     * @param d The draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColorOfLine());
        d.drawLine((int) this.start.getX(), (int) this.start.getY(), (int) this.end.getX(), (int) this.end.getY());
    }

    /**
     * This method notified the sprite that the time passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * This method gets the color of the line.
     * @return the color of the line.
     */
    public Color getColorOfLine() {
        return colorOfLine;
    }

    /**
     * This method sets the color of the line.
     * @param lineColor the color of the line.
     */
    public void setColorOfLine(Color lineColor) {
        this.colorOfLine = lineColor;
    }
}