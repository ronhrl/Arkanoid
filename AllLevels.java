
import java.awt.Color;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
abstract class AllLevels implements LevelInformation {
    private int widthOfScreen;
    private int heightOfScreen;
    private Color[] allColors = {Color.RED, Color.BLUE, Color.GREEN, Color.pink, Color.YELLOW,
            Color.DARK_GRAY, Color.LIGHT_GRAY};

    /**
     * Constructor method.
     * @param width  the width of the screen.
     * @param height the height of the screen.
     */
    AllLevels(int width, int height) {
        this.widthOfScreen = width;
        this.heightOfScreen = height;
    }

    /**
     * This method gets the width of the screen.
     * @return the width of the screen.
     */
    int getWidthOfScreen() {
        return this.widthOfScreen;
    }

    /**
     * This method gets the height of the screen.
     * @return the height of the screen.
     */
    int getHeightOfScreen() {
        return this.heightOfScreen;
    }

    /**
     * This method gets an array of all the colors.
     * @return the array of colors.
     */
    Color[] getAllColors() {
        return allColors;
    }
}