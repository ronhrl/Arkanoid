/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor method.
     * @param dx The dx of the velocity.
     * @param dy The dy of the velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This method returns the velocity vector.
     * @return The velocity vector.
     */
    public double getV() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }

    /**
     * Another constructor method.
     * this method defines the dx and dy of the velocity by using angle and speed.
     * @param angle The angle of the velocity.
     * @param speed The speed of the velocity.
     * @return The new Velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * This method move the ball from the point it's at to the new point.
     * this method uses the velocity to move from the point to the new place.
     * @param p The point we want to move from.
     * @return The new Point we are now at.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * This method get the dx of the velocity.
     * @return The dx of the velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * This method get the dy of the velocity.
     * @return The dy of the velocity.
     */
    public double getDy() {
        return this.dy;
    }
}