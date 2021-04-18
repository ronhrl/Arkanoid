
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class BlockInBackGround extends Block {
    private Color frameColor;

    /**
     * Constructor method.
     * @param rectangle the block shape we want to put in the background.
     */
    public BlockInBackGround(Rectangle rectangle) {
        super(rectangle);
    }

    /**
     * This method draw on the draw surface.
     * @param surface the surface we want to draw on.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(getCollisionRectangle().getColor());
        surface.fillRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(), (int) getCollisionRectangle().getWidth(),
                (int) getCollisionRectangle().getHeight());
        surface.setColor(getFrameColor());
        surface.drawRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(), (int) getCollisionRectangle().getWidth(),
                (int) getCollisionRectangle().getHeight());
    }

    /**
     *This method adds the block to the game.
     * @param gameLevel the game level we want to add to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        if (gameLevel == null) {
            return;
        }
        gameLevel.addSprite(this);
    }

    /**
     * This method gets the frame color.
     * @return the frame color.
     */
    public Color getFrameColor() {
        return frameColor;
    }

    /**
     * This method sets the frame color.
     * @param frameColors the frame color.
     */
    public void setFrameColor(Color frameColors) {
        this.frameColor = frameColors;
    }
}