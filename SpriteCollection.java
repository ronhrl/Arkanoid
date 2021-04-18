import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * Constructor method.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * This method adds the sprite to the sprites list.
     * @param s The sprite we want to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * This method notifies all sprites that the time passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new ArrayList<>(this.sprites);
        for (Sprite s : spritesCopy) {
            s.timePassed();
        }
    }

    /**
     * This method draw all the sprites to draw surface.
     * @param d The draw surface we want to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> spritesCopy = new ArrayList<>(this.sprites);
        for (Sprite s : spritesCopy) {
            s.drawOn(d);
        }
    }

    /**
     * This method removes the sprite from the sprite collection.
     * @param s The sprite we want to remove.
     */
    public void removeSpriteCol(Sprite s) {
        this.sprites.remove(s);
    }
}