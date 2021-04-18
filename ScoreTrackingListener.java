/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class ScoreTrackingListener implements HitListener {

    private Counter currentScore;

    /**
     * Constructor method.
     * @param scoreCount The score we want to put in the score tracking.
     */
    public ScoreTrackingListener(Counter scoreCount) {

        this.currentScore = scoreCount;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }

    /**
     * This method the returns the score.
     * @return The value of the score.
     */

    public int getValue() {
        return this.currentScore.getValue();
    }
}