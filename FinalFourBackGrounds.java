import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class FinalFourBackGrounds extends BackGroundForAll {

    /**
     * The Height of block subtitles.
     */
    static final double HEIGHT_OF_BLOCK_SUBTITLES = 20;
    /**
     * The Color of first circle.
     */
    static final Color FIRST_CIRCLE_COLOR = new Color(204, 204, 204);
    /**
     * The Color of second circle.
     */
    static final Color SECOND_CIRCLE_COLOR = new Color(160, 160, 160);
    /**
     * The Color of third circle.
     */
    static final Color THIRD_CIRCLE_COLOR = new Color(190, 190, 190);

    /**
     * The X of first circle.
     */
    static final double X_OF_FIST_CIRCLE = 120;
    /**
     * The Y of first circle.
     */
    static final double Y_OF_FIRST_CIRCLE = 400;
    /**
     * The radius of the first circle.
     */
    static final int RADIUS_OF_FIRST_CIRCLE = 20;

    /**
     * The Difference between first point to second in x.
     */
    static final double DIFFERENCE_BETWEEN_FIRST_POINT_TO_SECOND_IN_X = 30;
    /**
     * The Y of second circle.
     */
    static final double Y_OF_SECOND_CIRCLE = 390;
    /**
     * The radius of the second circle.
     */
    static final int RADIUS_OF_SECOND_CIRCLE = 30;

    /**
     * The Difference between first point to last in x.
     */
    static final double DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_IN_X = 60;
    /**
     * The Y of third circle.
     */
    static final double Y_OF_THIRD_CIRCLE = 400;
    /**
     * The radius of the third circle.
     */
    static final int RADIUS_OF_THIRD_CIRCLE = 30;

    /**
     * The Difference between first point to first under in x.
     */
    static final double DIFFERENCE_BETWEEN_FIRST_POINT_TO_FIRST_UNDER_IN_X = 15;
    /**
     * The Y of fourth circle.
     */
    static final double Y_OF_FOURTH_CIRCLE = 430;
    /**
     * The radius of the fourth circle.
     */
    static final int RADIUS_OF_FOURTH_CIRCLE = 25;

    /**
     * The Difference between first point to last under in x.
     */
    static final double DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_UNDER_IN_X = 50;
    /**
     * The Y of fifth circle.
     */
    static final double Y_OF_FIFTH_CIRCLE = 430;
    /**
     * The radius of the fifth circle.
     */
    static final int RADIUS_OF_FIFTH_CIRCLE = 25;

    /**
     * The Distance between start circle to start line.
     */
    static final double DISTANCE_BETWEEN_START_CIRCLE_TO_START_LINE = 10;
    /**
     * The distance between each line.
     */
    static final double DISTANCE_BETWEEN_EACH_LINE = 8;

    /**
     * The tendency of each line.
     */
    static final double TENDENCY_OF_EACH_LINE = 30;
    /**
     * The color of lines from clouds.
     */
    static final Color COLOR_OF_LINES_FROM_CLOUDS = Color.white;

    /**
     * Constructor method.
     * @param width  the width of the screen.
     * @param height the height of the screen.
     */
    public FinalFourBackGrounds(int width, int height) {
        super(width, height);
        createBlock(0, 0, getWidthOfScreen(), getHeightOfScreen(),
                Color.BLACK, new Color(51, 204, 255));
        createBlock(0, 0, getWidthOfScreen(), HEIGHT_OF_BLOCK_SUBTITLES,
                Color.BLACK, Color.LIGHT_GRAY);
        for (double i = X_OF_FIST_CIRCLE + DISTANCE_BETWEEN_START_CIRCLE_TO_START_LINE;
             i <= X_OF_FIST_CIRCLE + DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_IN_X
                     - DISTANCE_BETWEEN_START_CIRCLE_TO_START_LINE; i += DISTANCE_BETWEEN_EACH_LINE) {
            Point startLine = new Point(i, Y_OF_FIRST_CIRCLE);
            Point endLine = new Point(i - TENDENCY_OF_EACH_LINE, getHeightOfScreen());
            createLine(startLine, endLine, COLOR_OF_LINES_FROM_CLOUDS);
        }
        createCircle(X_OF_FIST_CIRCLE, Y_OF_FIRST_CIRCLE, RADIUS_OF_FIRST_CIRCLE, FIRST_CIRCLE_COLOR);
        createCircle(X_OF_FIST_CIRCLE + DIFFERENCE_BETWEEN_FIRST_POINT_TO_SECOND_IN_X,
                Y_OF_SECOND_CIRCLE, RADIUS_OF_SECOND_CIRCLE, SECOND_CIRCLE_COLOR);
        createCircle(X_OF_FIST_CIRCLE + DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_IN_X,
                Y_OF_THIRD_CIRCLE, RADIUS_OF_THIRD_CIRCLE, THIRD_CIRCLE_COLOR);
        createCircle(X_OF_FIST_CIRCLE + DIFFERENCE_BETWEEN_FIRST_POINT_TO_FIRST_UNDER_IN_X,
                Y_OF_FOURTH_CIRCLE, RADIUS_OF_FOURTH_CIRCLE, SECOND_CIRCLE_COLOR);
        createCircle(X_OF_FIST_CIRCLE + DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_UNDER_IN_X,
                Y_OF_FIFTH_CIRCLE, RADIUS_OF_FIFTH_CIRCLE, THIRD_CIRCLE_COLOR);
        double startX = getWidthOfScreen() - X_OF_FIST_CIRCLE - (2 * DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_IN_X);
        for (double i = startX + DISTANCE_BETWEEN_START_CIRCLE_TO_START_LINE;
             i <= startX + DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_IN_X
                     - DISTANCE_BETWEEN_START_CIRCLE_TO_START_LINE; i += DISTANCE_BETWEEN_EACH_LINE) {
            Point startLine = new Point(i, Y_OF_FIRST_CIRCLE);
            Point endLine = new Point(i - TENDENCY_OF_EACH_LINE, getHeightOfScreen());
            createLine(startLine, endLine, COLOR_OF_LINES_FROM_CLOUDS);
        }
        createCircle(startX, Y_OF_FIRST_CIRCLE, RADIUS_OF_FIRST_CIRCLE, FIRST_CIRCLE_COLOR);
        createCircle(startX + DIFFERENCE_BETWEEN_FIRST_POINT_TO_SECOND_IN_X,
                Y_OF_SECOND_CIRCLE, RADIUS_OF_SECOND_CIRCLE, SECOND_CIRCLE_COLOR);
        createCircle(startX + DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_IN_X,
                Y_OF_THIRD_CIRCLE, RADIUS_OF_THIRD_CIRCLE, THIRD_CIRCLE_COLOR);
        createCircle(startX + DIFFERENCE_BETWEEN_FIRST_POINT_TO_FIRST_UNDER_IN_X,
                Y_OF_FOURTH_CIRCLE, RADIUS_OF_FOURTH_CIRCLE, SECOND_CIRCLE_COLOR);
        createCircle(startX + DIFFERENCE_BETWEEN_FIRST_POINT_TO_LAST_UNDER_IN_X,
                Y_OF_FIFTH_CIRCLE, RADIUS_OF_FIFTH_CIRCLE, THIRD_CIRCLE_COLOR);
    }

    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
    }

    @Override
    public void timePassed() {

    }
}