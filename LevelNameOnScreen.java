import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class LevelNameOnScreen implements Sprite {

    private LevelInformation levelInformation;

    /**
     * Constructor method.
     * @param levelInf the information about the level.
     */
    public LevelNameOnScreen(LevelInformation levelInf) {
        this.levelInformation = levelInf;
    }

    /**
     * This method draw the sprite to the draw surface.
     *
     * @param d The draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        double width, height, x;
        String levelName = this.levelInformation.levelName();
        x = 530;
        width = 30;
        height = 20;
        d.setColor(Color.BLACK);
        d.drawText((int) (x + (width / 2)), (int) ((height / 2) + 7), "Level Name: " + levelName, 18);
    }

    /**
     * This method notified the sprite that the time passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * This method adds the sprite to the game.
     * @param gl the game we want to add to.
     */
    public void addToGame(GameLevel gl) {
        gl.addSprite(this);
    }
}