/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public interface HitNotifier {

    /**
     * This method adds a hit listener to hit events.
     * @param hl The hit listener we want to add to the hit events.
     */
    void addHitListener(HitListener hl);


    /**
     * This method removes hit listener from the list of listeners to hit events.
     * @param hl The hit listener we want to remove.
     */
    void removeHitListener(HitListener hl);
}