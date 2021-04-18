import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;

    /**
     * Constructor method.
     * @param upperLeft The upper left point.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param color The color of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
    this.upperLeft = upperLeft;
    this.width = width;
    this.height = height;
    this.color = color;
    }

    /**
     * This method finds all the intersection points between the line and the rectangle.
     * @param line The line we want to find the intersection point with.
     * @return List of all the intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        double x1, y1, x2, y2;
        x1 = this.upperLeft.getX() + width;
        y1 = this.upperLeft.getY();
        x2 = this.upperLeft.getX();
        y2 = this.upperLeft.getY() + height;
        Point upperRight = new Point(x1, y1);
        Point lowerLeft = new Point(x2, y2);
        Point lowerRight = new Point(x1, y2);
        Line upperLine = new Line(this.upperLeft, upperRight);
        Line lowerLine = new Line(lowerLeft, lowerRight);
        Line leftLine = new Line(this.upperLeft, lowerLeft);
        Line rightLine = new Line(upperRight, lowerRight);
        List<Point> list = new ArrayList<>();
        if (leftLine.isIntersecting(line)) {
            list.add(leftLine.intersectionWith(line));
        }
        if (rightLine.isIntersecting(line)) {
            list.add(rightLine.intersectionWith(line));
        }
        if (upperLine.isIntersecting(line)) {
            list.add(upperLine.intersectionWith(line));
        }
        if (lowerLine.isIntersecting(line)) {
            list.add(lowerLine.intersectionWith(line));
        }
        return list;
    }

    /**
     * This method returns the color of the rectangle.
     * @return The color of the rectangle.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * This method returns the width of the rectangle.
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * This method returns the height of the rectangle.
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * This method returns the upper left point of the rectangle.
     * @return The height of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * This method returns the lower left point of the rectangle.
     * @return The height of the rectangle.
     */
    public Point getLowerLeft() {
        double x1, y1;
        x1 = this.upperLeft.getX();
        y1 = this.upperLeft.getY() + this.height;
        return new Point(x1, y1);
    }
    /**
     * This method returns the upper right point of the rectangle.
     * @return The height of the rectangle.
     */
    public Point getUpperRight() {
        double x1, y1;
        x1 = this.upperLeft.getX() + this.width;
        y1 = this.upperLeft.getY();
        return new Point(x1, y1);
    }
    /**
     * This method returns the lower right point of the rectangle.
     * @return The height of the rectangle.
     */
    public Point getLowerRight() {
        double x1, y1;
        x1 = this.upperLeft.getX() + this.width;
        y1 = this.upperLeft.getY() + this.height;
        return new Point(x1, y1);
    }

    /**
     * This method draw the rectangle to draw surface.
     * @param d The draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.width, (int) this.height);
        d.setColor(this.color);
        d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.width, (int) this.height);
    }
}