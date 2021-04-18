/**
 * @author ID 308433762
 * version 1
 * since 31/05/2020
 */

public class BallRemover implements HitListener {

    private GameLevel ge;
    private Counter remainingBalls;

    /**
     * Constructor method.
     * @param gameLevel The game we want to move the ball from.
     * @param remainingB The remaining balls in the game.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingB) {
        this.ge = gameLevel;
        this.remainingBalls = remainingB;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.ge);
        this.remainingBalls.decrease(1);
    }
}