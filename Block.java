import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import biuoop.DrawSurface;


/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private List<HitListener> hitListeners;

    /**
     * Constructor method.
     * @param rect The shape of the block.
     */
    public Block(Rectangle rect) {
        this.rectangle = rect;
        this.hitListeners = new LinkedList<>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double epsilon = Math.pow(10, -9);

        if (Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) <= epsilon) {
            this.notifyHit(hitter);
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        if (Math.abs(collisionPoint.getX() - this.rectangle.getUpperRight().getX()) <= epsilon) {
            this.notifyHit(hitter);
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        if (Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) <= epsilon) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        if (Math.abs(collisionPoint.getY() - this.rectangle.getLowerLeft().getY()) <= epsilon) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }

        this.notifyHit(hitter);
        return new Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());
    }

    /**
     * This method draw the block on the draw surface.
     * @param surface The surface we want to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        surface.setColor(this.rectangle.getColor());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    @Override
    public void timePassed() {

    }

    /**
     * This method adds the block to the game.
     * @param g The game we want to add the block to.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * This method removes the block from the game.
     * @param gameLevel The game we want to remove blocks from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        if (gameLevel == null) {
            return;
        }
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * This method notifies the block that they are being hit.
     * @param hitter The ball that hits the blocks.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event.
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * This method gets the list of the hit listeners.
     * @return The list of the hit listeners.
     */
    public List<HitListener> getHitListeners() {
        return this.hitListeners;
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}