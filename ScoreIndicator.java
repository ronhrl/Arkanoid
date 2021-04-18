import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class ScoreIndicator implements Sprite {

    private ScoreTrackingListener score;

    /**
     * Constructor method.
     * @param score The score we want to put in the score indicator.
     */
    public ScoreIndicator(ScoreTrackingListener score) {
        this.score = score;
    }

    /**
     * This method draw the sprite to the draw surface.
     * @param d The draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        double width, height, x;
        String string;
        string = "" + this.score.getValue();
        x = 350;
        width = 30;
        height = 20;
        d.setColor(Color.BLACK);
        d.drawRectangle(0, 0, 800, 25);
        d.setColor(Color.cyan);
        d.fillRectangle(0, 0, 800 , 25);
        d.setColor(Color.BLACK);
        d.drawText((int) (x + (width / 2)), (int) ((height / 2) + 7), "Score: " + string, 20);
    }

    /**
     * This method adds the score to the game.
     * @param ge The game we want to add the score to.
     */
    public void addToGame(GameLevel ge) {
        ge.addSprite(this);
    }

    /**
     * This method notified the sprite that the time passed.
     */
    @Override
    public void timePassed() {

    }
}