
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public interface HitListener {


    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit The block that has been hit.
     * @param hitter The ball that hits the object.
     */
    void hitEvent(Block beingHit, Ball hitter);
}