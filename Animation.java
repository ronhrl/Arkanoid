import biuoop.DrawSurface;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public interface Animation {
    /**
     * This method do one frame of the game.
     * @param d the draw surface we want to do the one frame.
     */
    void doOneFrame(DrawSurface d);

    /**
     * This method checks if the game should stop.
     * @return boolean value.
     */
    boolean shouldStop();
}