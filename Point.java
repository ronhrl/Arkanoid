/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor method of the object point.
     * @param x The x value of the point.
     * @param y The y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This method calculates the distance between two points.
     * @param other A point from the user.
     * @return The value of the distance between the two points.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    /**
     * This method checks if two points are the same.
     * @param other A point from the user.
     * @return True if it's the same points.
     */
    public boolean equals(Point other) {
        return this.x == other.x && this.y == other.y;
    }

    /**
     * This method gives the x value of the point.
     * @return x value of the point.
     */

    public double getX() {
        return this.x;
    }
    /**
     * This method gives the y value of the point.
     * @return y value of the point.
     */

    public double getY() {
        return this.y;
    }

}