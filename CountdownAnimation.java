import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {

    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection spriteCollection;
    private boolean stop;
    private double count;

    static final int SECONDS_TO_MULT = 1000;

    /**
     * Constructor method.
     * @param numOfSeconds the num of seconds we want the animation
     * to display on the screen.
     * @param countFrom the num of seconds we want to count from.
     * @param gameScreen the screen we want the animation display on.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.spriteCollection = gameScreen;
        this.count = this.countFrom;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.spriteCollection.drawAllOn(d);
        if (countFrom <= 0) {
            this.stop = true;
        }
            String string = " " + this.countFrom;
            d.setColor(Color.RED);
            d.drawText(350, d.getHeight() / 2, " " + string, 83);
            if (countFrom != 3) {
                sleeper.sleepFor(SECONDS_TO_MULT * (long) (this.numOfSeconds / this.count));
            }
        this.countFrom -= 1;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}