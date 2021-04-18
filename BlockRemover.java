/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class BlockRemover implements HitListener {

    private GameLevel ge;
    private Counter remainingBlocks;

    /**
     * Constructor method.
     * @param gameLevel The game we want to be able to move blocks from.
     * @param removedBlocks The counter of the removed blocks from the game.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.ge = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.ge);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}