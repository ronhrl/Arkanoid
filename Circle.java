import biuoop.DrawSurface;

import java.awt.Color;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class Circle implements Sprite {
    private Point centerCircle;
    private int radius;
    private Color colorOfFrameCircle;
    private Color colorInsideCircle;

    /**
     * Constructor method.
     * @param center the center of the circle.
     * @param radius the radius of the circle.
     * @param frameCircleColor the color of frame circle.
     * @param insideCircleColor the color inside the circle.
     */
    public Circle(Point center, int radius, Color frameCircleColor, Color insideCircleColor) {
        this.centerCircle = center;
        this.radius = radius;
        this.colorOfFrameCircle = frameCircleColor;
        this.colorInsideCircle = insideCircleColor;
    }

    /**
     * Constructor method.
     * @param centerX the x value of the center.
     * @param centerY the y value of the center.
     * @param radius the radius of the circle.
     * @param frameCircleColor the color of frame circle.
     * @param insideCircleColor  the color inside circle.
     */
    public Circle(double centerX, double centerY, int radius, Color frameCircleColor, Color insideCircleColor) {
        this.centerCircle = new Point(centerX, centerY);
        this.radius = radius;
        this.colorOfFrameCircle = frameCircleColor;
        this.colorInsideCircle = insideCircleColor;
    }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColorOfFrameCircle());
        d.drawCircle(getX(), getY(), getRadius());
        d.setColor(getColorInsideCircle());
        d.fillCircle(getX(), getY(), getRadius());
    }

    @Override
    public void timePassed() {

    }

    /**
     * This method adds the circle to the game.
     * @param g the game level we want to add to.
     */
    public void addToGame(GameLevel g) {
        if (g == null) {
            return;
        }
        g.addSprite(this);
    }

    /**
     * This method gets center of the circle.
     *
     * @return the center of the circle.
     */
    public Point getCenterCircle() {
        return centerCircle;
    }

    /**
     * This method gets the radius.
     * @return the radius of the circle.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * This method gets the color of the circle frame.
     * @return the color of the circle frame.
     */
    public Color getColorOfFrameCircle() {
        return colorOfFrameCircle;
    }

    /**
     * This method gets the color inside circle.
     * @return the color inside the circle.
     */
    public Color getColorInsideCircle() {
        return colorInsideCircle;
    }

    /**
     * This method gets the x value.
     * @return the x value.
     */
    public int getX() {
        return (int) getCenterCircle().getX();
    }

    /**
     * This method gets the y value.
     * @return the y value.
     */
    public int getY() {
        return (int) getCenterCircle().getY();
    }
}