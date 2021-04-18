import java.awt.Color;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class DirectHitBackGround extends BackGroundForAll {

    /**
     * Constructor method.
     * @param width the width of the screen.
     * @param height the height of the screen.
     */

    public DirectHitBackGround(int width, int height) {
        super(width, height);
        createBlock(0, 0, getWidthOfScreen(), getHeightOfScreen(),
                Color.BLACK, Color.BLACK);
        createBlock(0, 0, getWidthOfScreen(), 20,
                Color.BLACK, Color.LIGHT_GRAY);
        createCircle(getWidthOfScreen() / 2.0, 150, 100,
                Color.BLUE, Color.BLACK);
        createCircle(getWidthOfScreen() / 2.0, 150, 70,
                Color.BLUE, Color.BLACK);
        createCircle(getWidthOfScreen() / 2.0, 150, 40,
                Color.BLUE, Color.BLACK);
        createLine(new Point(getWidthOfScreen() / 2.0, 50),
                new Point(getWidthOfScreen() / 2.0, 250), Color.BLUE);
        createLine(new Point((getWidthOfScreen() / 2.0) - 100, 150),
                new Point((getWidthOfScreen() / 2.0) + 100, 150), Color.BLUE);

    }
}