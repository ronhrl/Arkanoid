import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */


public class Green3BackGround extends BackGroundForAll {

    /**
     * The height of the block subtitles.
     */
    static final double HEIGHT_OF_BLOCK_SUBTITLES = 20;
    /**
     * The x start of lower block.
     */
    static final double X_START_OF_LOWER_BLOCK = 80;
    /**
     * The y start of lower block.
     */
    static final double Y_START_OF_LOWER_BLOCK = 450;
    /**
     * The Width of lower block.
     */
    static final double WIDTH_OF_LOWER_BLOCK = 110;
    /**
     * The height of lower block.
     */
    static final double HEIGHT_OF_LOWER_BLOCK = 150;

    /**
     * The x start of middle block.
     */
    static final double X_START_OF_MIDDLE_BLOCK = 120;
    /**
     * The y start of middle block.
     */
    static final double Y_START_OF_MIDDLE_BLOCK = 400;
    /**
     * The width of middle block.
     */
    static final double WIDTH_OF_MIDDLE_BLOCK = 30;
    /**
     * The height of middle block.
     */
    static final double HEIGHT_OF_MIDDLE_BLOCK = 50;

    /**
     * The x start of higher block.
     */
    static final double X_START_OF_HIGHER_BLOCK = 130;
    /**
     * The y start of higher block.
     */
    static final double Y_START_OF_HIGHER_BLOCK = 250;
    /**
     * The width of higher block.
     */
    static final double WIDTH_OF_HIGHER_BLOCK = 10;
    /**
     * The height of higher block.
     */
    static final double HEIGHT_OF_HIGHER_BLOCK = 150;

    /**
     * The x start center circle.
     */
    static final double X_START_CENTER_CIRCLE = 135;
    /**
     * The y start center circle.
     */
    static final double Y_START_CENTER_CIRCLE = 235;
    /**
     * The radius of the biggest circle.
     */
    static final int RADIUS_OF_BIGGEST_CIRCLE = 15;
    /**
     * The radius of the middle circle.
     */
    static final int RADIUS_OF_MIDDLE_CIRCLE = 10;
    /**
     * The radius of the smallest circle.
     */
    static final int RADIUS_OF_SMALLEST_CIRCLE = 5;

    /**
     * The width of small block.
     */
    static final double WIDTH_OF_SMALL_BLOCK = 10;
    /**
     * The height of small block.
     */
    static final double HEIGHT_OF_SMALL_BLOCK = 15;
    /**
     * The color of small block.
     */
    static final Color COLOR_OF_SMALL_BLOCK = Color.white;
    /**
     * The space between small blocks in lower block.
     */
    static final double SPACE_BETWEEN_SMALL_BLOCKS_IN_LOWER_BLOCK = 10;
    /**
     * The color of the biggest circle.
     */
    static final Color COLOR_OF_BIGGEST_CIRCLE = Color.orange;
    /**
     * The color of the middle circle.
     */
    static final Color COLOR_OF_MIDDLE_CIRCLE = Color.red;
    /**
     * The color of the smallest circle.
     */
    static final Color COLOR_OF_SMALLEST_CIRCLE = Color.white;
    /**
     * The color of the gui.
     */
    static final Color COLOR_OF_GUI = new Color(0, 153, 0);
    /**
     * Constructor method.
     * @param width the width of the screen.
     * @param height the height of the screen.
     */
    public Green3BackGround(int width, int height) {
        super(width, height);
        createBlock(0, 0, getWidthOfScreen(), getHeightOfScreen(),
                Color.BLACK, COLOR_OF_GUI);
        createBlock(0, 0, getWidthOfScreen(), HEIGHT_OF_BLOCK_SUBTITLES,
                Color.BLACK, Color.LIGHT_GRAY);
        createBlock(X_START_OF_LOWER_BLOCK, Y_START_OF_LOWER_BLOCK, WIDTH_OF_LOWER_BLOCK,
                HEIGHT_OF_LOWER_BLOCK, Color.black, Color.black);
        for (double i = Y_START_OF_LOWER_BLOCK + SPACE_BETWEEN_SMALL_BLOCKS_IN_LOWER_BLOCK;
             i < getHeightOfScreen();
             i += SPACE_BETWEEN_SMALL_BLOCKS_IN_LOWER_BLOCK + HEIGHT_OF_SMALL_BLOCK) {
            for (double j = X_START_OF_LOWER_BLOCK + SPACE_BETWEEN_SMALL_BLOCKS_IN_LOWER_BLOCK;
                 j < X_START_OF_LOWER_BLOCK + WIDTH_OF_LOWER_BLOCK - SPACE_BETWEEN_SMALL_BLOCKS_IN_LOWER_BLOCK;
                 j += SPACE_BETWEEN_SMALL_BLOCKS_IN_LOWER_BLOCK + WIDTH_OF_SMALL_BLOCK) {
                 createBlock(j, i, WIDTH_OF_SMALL_BLOCK, HEIGHT_OF_SMALL_BLOCK,
                        COLOR_OF_SMALL_BLOCK, COLOR_OF_SMALL_BLOCK);

            }
        }
        createBlock(X_START_OF_MIDDLE_BLOCK, Y_START_OF_MIDDLE_BLOCK, WIDTH_OF_MIDDLE_BLOCK,
                HEIGHT_OF_MIDDLE_BLOCK, Color.DARK_GRAY, Color.DARK_GRAY);
        createBlock(X_START_OF_HIGHER_BLOCK, Y_START_OF_HIGHER_BLOCK, WIDTH_OF_HIGHER_BLOCK,
                HEIGHT_OF_HIGHER_BLOCK, Color.GRAY, Color.GRAY);
        createCircle(X_START_CENTER_CIRCLE, Y_START_CENTER_CIRCLE, RADIUS_OF_BIGGEST_CIRCLE,
                COLOR_OF_BIGGEST_CIRCLE, COLOR_OF_BIGGEST_CIRCLE);
        createCircle(X_START_CENTER_CIRCLE, Y_START_CENTER_CIRCLE, RADIUS_OF_MIDDLE_CIRCLE,
                COLOR_OF_MIDDLE_CIRCLE, COLOR_OF_MIDDLE_CIRCLE);
        createCircle(X_START_CENTER_CIRCLE, Y_START_CENTER_CIRCLE, RADIUS_OF_SMALLEST_CIRCLE,
                COLOR_OF_SMALLEST_CIRCLE, COLOR_OF_SMALLEST_CIRCLE);
    }

    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
    }

    @Override
    public void timePassed() {

    }
}