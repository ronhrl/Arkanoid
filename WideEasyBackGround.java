import java.awt.Color;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class WideEasyBackGround extends BackGroundForAll {
    /**
     * The x of circle of the sun.
     */
    static final int X_OF_CIRCLE_SUN = 200;
    /**
     * The y of circle of the sun.
     */
    static final int Y_OF_CIRCLE_SUN = 120;

    /**
     * The radius of the big sun.
     */
    static final int RADIUS_BIG_SUN = 50;
    /**
     * The radius of the second sun.
     */
    static final int RADIUS_SECOND_SUN = 40;
    /**
     * The radius of the small sun.
     */
    static final int RADIUS_SMALL_SUN = 30;

    /**
     * The color of the big sun.
     */
    static final Color COLOR_BIG_SUN = new Color(255, 240, 153);
    /**
     * The color of the second sun.
     */
    static final Color COLOR_SECOND_SUN = new Color(255, 255, 0);
    /**
     * The color of the small sun.
     */
    static final Color COLOR_SMALL_SUN = new Color(255, 220, 0);

    /**
     * The color of the lines from the sun.
     */
    static final Color COLOR_LINES_FROM_SUN = new Color(255, 240, 153);

    /**
     * The x start of line.
     */
    static final int X_START_OF_LINE = 20;
    /**
     * The x end of line.
     */
    static final int X_END_OF_LINE = 780;
    /**
     * The start point of line.
     */
    static final Point START_POINT_OF_LINE = new Point(200, 120);
    /**
     * The y end of line.
     */
    static final double Y_END_OF_LINE = 250;
    /**
     * The Distance between lines.
     */
    static final double DISTANCE_BETWEEN_LINES = 10;
    /**
     * The height of block subtitles.
     */
    static final double HEIGHT_OF_BLOCK_SUBTITLES = 20;

    /**
     * Constructor method.
     * @param width the width of the screen.
     * @param height the height of the screen.
     */
    public WideEasyBackGround(int width, int height) {
        super(width, height);
        createBlock(0, 0, getWidthOfScreen(), getHeightOfScreen(),
                Color.BLACK, Color.white);
        createBlock(0, 0, getWidthOfScreen(), HEIGHT_OF_BLOCK_SUBTITLES,
                Color.BLACK, Color.LIGHT_GRAY);

        for (double i = X_START_OF_LINE; i <= X_END_OF_LINE; i += DISTANCE_BETWEEN_LINES) {
            Point start = START_POINT_OF_LINE;
            Point end = new Point(i, Y_END_OF_LINE);
            createLine(start, end, COLOR_LINES_FROM_SUN);
        }
        createCircle(X_OF_CIRCLE_SUN, Y_OF_CIRCLE_SUN, RADIUS_BIG_SUN, COLOR_BIG_SUN);
        createCircle(X_OF_CIRCLE_SUN, Y_OF_CIRCLE_SUN, RADIUS_SECOND_SUN, COLOR_SECOND_SUN);
        createCircle(X_OF_CIRCLE_SUN, Y_OF_CIRCLE_SUN, RADIUS_SMALL_SUN, COLOR_SMALL_SUN);
    }
}