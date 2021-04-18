/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructor method.
     * @param colliesP The point that the collision happened.
     * @param colliesObj The object that was collided.
     */
    public CollisionInfo(Point colliesP, Collidable colliesObj) {
        this.collisionPoint = colliesP;
        this.collisionObject = colliesObj;
    }

    /**
     * This method returns the collision point.
     * @return The collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * This method returns the collision object.
     * @return The collision object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }

    /**
     * Check side of collision char.
     *
     * @return the char
     */
    public String checkSideOfCollision() {
        if ((collisionPoint().getX() == collisionObject().getCollisionRectangle().getUpperRight().getX())
                && collisionPoint().getY() == collisionObject().getCollisionRectangle().getUpperRight().getY()) {
            return "upperRight";
        }
        if ((collisionPoint().getX() == collisionObject().getCollisionRectangle().getUpperLeft().getX())
                && collisionPoint().getY() == collisionObject().getCollisionRectangle().getUpperLeft().getY()) {
            return "UpperLeft";
        }
        if ((collisionPoint().getX() == collisionObject().getCollisionRectangle().getLowerRight().getX())
                && collisionPoint().getY() == collisionObject().getCollisionRectangle().getLowerRight().getY()) {
            return "DownRight";
        }
        if ((collisionPoint().getX() == collisionObject().getCollisionRectangle().getLowerLeft().getX())
                && collisionPoint().getY() == collisionObject().getCollisionRectangle().getLowerLeft().getY()) {
            return "DownLeft";
        }
        if (collisionPoint().getX() == collisionObject().getCollisionRectangle().getUpperRight().getX()) {
            return "right";
        }
        if (collisionPoint().getX() == collisionObject().getCollisionRectangle().getUpperLeft().getX()) {
            return "left";
        }
        if (collisionPoint().getY() == collisionObject().getCollisionRectangle().getUpperRight().getY()) {
            return "up";
        }
        return "down";
    }
}