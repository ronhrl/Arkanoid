/**
 * @author ID 308433762
 * version 1
 * since 31/05/2020
 */
public interface Collidable {
    /**
     * This method returns the shape of the collision object.
     * @return The shape of the collision object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Change the velocity of the ball according to where it hit.
     * @param hitter The ball that hits the collidable objects.
     * @param collisionPoint The point the collision accord.
     * @param currentVelocity The current velocity of the ball
     * @return The new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}