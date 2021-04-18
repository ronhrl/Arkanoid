import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public abstract class BackGroundForAll implements Sprite {
    private List<Sprite> spriteList = new ArrayList<>();
    private int widthOfScreen;
    private int heightOfScreen;

    /**
     * Constructor method.
     * @param width the width of the screen.
     * @param height the height of the screen.
     */
    public BackGroundForAll(int width, int height) {
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


    @Override
    public void drawOn(DrawSurface d) {
        for (Sprite s: getSpriteList()) {
            s.drawOn(d);
        }
    }

    @Override
    public void timePassed() {

    }

    /**
     * This method adds this sprite to the game.
     * @param g the game level we want to add to.
     */
    public void addToGame(GameLevel g) {
        for (Sprite s: getSpriteList()) {
            g.addSprite(s);
        }
    }

    /**
     * This method gets the sprite list.
     * @return the sprite list.
     */
    public List<Sprite> getSpriteList() {
        return spriteList;
    }

    /**
     * This method creates a circle.
     *
     * @param centerX the x value of the center.
     * @param centerY the y value of the center.
     * @param radius the radius.
     * @param colorFrame the color frame.
     * @param colorInside the color inside the circle.
     */
    public void createCircle(double centerX, double centerY, int radius, Color colorFrame, Color colorInside) {
        Circle circle = new Circle(centerX, centerY, radius, colorFrame, colorInside);
        getSpriteList().add(circle);
    }

    /**
     * This method creates a circle.
     *
     * @param centerX the x value of the center.
     * @param centerY the y value of the center.
     * @param radius the radius.
     * @param colorInside the color inside the circle.
     */
    public void createCircle(double centerX, double centerY, int radius, Color colorInside) {
        Circle circle = new Circle(centerX, centerY, radius, colorInside, colorInside);
        getSpriteList().add(circle);
    }
    /**
     * This method creates a block.
     *
     * @param xUpperLeft the x of the upper left point.
     * @param yUpperLeft the y of the upper left point.
     * @param width the width of the block.
     * @param height the height of the block.
     * @param colorFrame the color frame of the block.
     * @param colorInside the color inside the block.
     */
    public void createBlock(double xUpperLeft, double yUpperLeft, double width, double height,
                            Color colorFrame, Color colorInside) {
        Point point = new Point(xUpperLeft, yUpperLeft);
        Rectangle rec = new Rectangle(point, width, height, colorInside);
        BlockInBackGround blockInBackGround = new BlockInBackGround(rec);
        blockInBackGround.setFrameColor(colorFrame);
        getSpriteList().add(blockInBackGround);
    }

    /**
     * This method creates a line.
     *
     * @param start the point start of the line.
     * @param end the point end of the line.
     * @param color the color of the line.
     */
    public void createLine(Point start, Point end, Color color) {
        Line line = new Line(start, end);
        line.setColorOfLine(color);
        getSpriteList().add(line);
    }
}