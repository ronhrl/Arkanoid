import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class WinScreen implements Animation {

    private int score;

    /**
     * Constructor method.
     * @param sc the score.
     */
    public WinScreen(int sc) {
        this.score = sc;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLUE);
        d.drawText(200, 150, "You Win!", 80);
        d.drawText(90, 320, "Your Score Is: " + getScore(), 80);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }

    /**
     * This method gets the count score.
     *
     * @return the count score.
     */
    public int getScore() {
        return score;
    }
}