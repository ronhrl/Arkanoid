import biuoop.DrawSurface;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public interface Sprite {
    /**
     * This method draw the sprite to the draw surface.
     * @param d The draw surface.
     */
    void drawOn(DrawSurface d);

    /**
     * This method notified the sprite that the time passed.
     */
    void timePassed();
}