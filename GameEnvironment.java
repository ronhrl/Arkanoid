import java.util.ArrayList;
import java.util.List;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class GameEnvironment  {
    private List<Collidable> collidables;

    /**
     * Constructor method.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * This method adds a collidable to the collidables list.
     * @param c The collidable we want to add.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * This method find the information about the closest collision to the start of line.
     * @param trajectory The line that we want to find the closest collision to its start point.
     * @return The information about that collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Rectangle rect;
        double dis, minDis;
        Collidable collidable = null;
        minDis = trajectory.start().distance(trajectory.end());
        Point minP = null;
        Point colP;
        for (Collidable c : this.collidables) {
            rect = c.getCollisionRectangle();
            colP = trajectory.closestIntersectionToStartOfLine(rect);
            if (colP != null) {
                dis = colP.distance(trajectory.start());
                if (dis < minDis) {
                    minDis = dis;
                    collidable = c;
                    minP = colP;
                }
            }
        }
        if (minP == null) {
            return null;
        }
        return new CollisionInfo(minP, collidable);
    }

    /**
     * This method removes the collidable object from the game environment.
     * @param c The collidable we want to remove.
     */
    public void removeCollidableGe(Collidable c) {
        this.collidables.remove(c);
    }
}