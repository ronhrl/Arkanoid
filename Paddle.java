import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class Paddle implements Sprite, Collidable {

    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private double boardWidth;
    private Point regionP1;
    private Point regionP2;
    private Point regionP3;
    private Point regionP4;
    private Point regionP5;
    private Point regionP6;
    private Point beginningUpperLeft;
    private double move;

    /**
     *Constructor method.
     * @param rectangle The shape of the paddle.
     * @param width The width of the screen.
     * @param keyboard The keyboard that moves the paddle.
     * @param speed the speed of the velocity.
     */
    public Paddle(Rectangle rectangle, double width, KeyboardSensor keyboard, double speed) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.boardWidth = width;
        this.regionP1 = new Point(this.rectangle.getUpperLeft().getX(), this.rectangle.getUpperLeft().getY());
        this.regionP2 = new Point(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 5
                , this.rectangle.getUpperLeft().getY());
        this.regionP3 = new Point(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 5 * 2
                , this.rectangle.getUpperLeft().getY());
        this.regionP4 = new Point(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 5 * 3
                , this.rectangle.getUpperLeft().getY());
        this.regionP5 = new Point(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 5 * 4
                , this.rectangle.getUpperLeft().getY());
        this.regionP6 = new Point(this.rectangle.getUpperRight().getX(), this.rectangle.getUpperRight().getY());
        this.beginningUpperLeft = rectangle.getUpperLeft();
        this.move = speed;
    }
    /**
     * This method gets upper left point in the beginning.
     * @return the upper left in beginning.
     */
    private Point getBeginningUpperLeft() {
        return beginningUpperLeft;
    }


    /**
     * This method moving the paddle left.
     * The method updates the values of the paddle after we move it to the left.
     */
    public void moveLeft() {
        Rectangle rect = this.getCollisionRectangle();
        Point newUpLeft = this.leftV().applyToPoint(rect.getUpperLeft());
        if (newUpLeft.getX() > 10) {
            this.rectangle = new Rectangle(newUpLeft, rect.getWidth(), rect.getHeight(),
                    rect.getColor());
            this.regionP1 = new Point(this.regionP1.getX() - move, this.regionP1.getY());
            this.regionP2 = new Point(this.regionP2.getX() - move, this.regionP2.getY());
            this.regionP3 = new Point(this.regionP3.getX() - move, this.regionP3.getY());
            this.regionP4 = new Point(this.regionP4.getX() - move, this.regionP4.getY());
            this.regionP5 = new Point(this.regionP5.getX() - move, this.regionP5.getY());
            this.regionP6 = new Point(this.regionP6.getX() - move, this.regionP6.getY());
        }
    }
    /**
     * This method moving the paddle right.
     * The method updates the values of the paddle after we move it to the right.
     */
    public void moveRight() {
        Rectangle rect = this.getCollisionRectangle();
        Point newUplLeft = this.rightV().applyToPoint(rect.getUpperLeft());
        if (newUplLeft.getX() + rect.getWidth() < boardWidth) {
            this.rectangle = new Rectangle(newUplLeft, rect.getWidth(), rect.getHeight(),
                    rect.getColor());
            this.regionP1 = new Point(this.regionP1.getX() + this.move, this.regionP1.getY());
            this.regionP2 = new Point(this.regionP2.getX() + this.move, this.regionP2.getY());
            this.regionP3 = new Point(this.regionP3.getX() + this.move, this.regionP3.getY());
            this.regionP4 = new Point(this.regionP4.getX() + this.move, this.regionP4.getY());
            this.regionP5 = new Point(this.regionP5.getX() + this.move, this.regionP5.getY());
            this.regionP6 = new Point(this.regionP6.getX() + this.move, this.regionP6.getY());
        }
    }

    /**
     * This method adds the paddle to the game.
     * @param g The game we want to add the paddle to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * this method updates the velocity of the ball according to where it hit the paddle.
     * @param hitter the ball that hits the paddle.
     * @param collisionPoint the point the collision accord.
     * @param currentVelocity the current velocity of the ball.
     * @return the new velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v1;
        double v2;
        v2 = currentVelocity.getV();
        if (collisionPoint.getX() >= this.regionP1.getX() && collisionPoint.getX() < this.regionP2.getX()) {
            v1 = Velocity.fromAngleAndSpeed(300, v2);
            return new Velocity(v1.getDx(), v1.getDy());
        }
        if (collisionPoint.getX() >= this.regionP2.getX() && collisionPoint.getX() < this.regionP3.getX()) {
            v1 = Velocity.fromAngleAndSpeed(330, v2);
            return new Velocity(v1.getDx(), v1.getDy());
        }
        if (collisionPoint.getX() >= this.regionP3.getX() && collisionPoint.getX() < this.regionP4.getX()) {
            v1 = Velocity.fromAngleAndSpeed(0, v2);
            return new Velocity(v1.getDx(), v1.getDy());
        }
        if (collisionPoint.getX() >= this.regionP4.getX() && collisionPoint.getX() < this.regionP5.getX()) {
            v1 = Velocity.fromAngleAndSpeed(30, v2);
            return new Velocity(v1.getDx(), v1.getDy());
        }
        if (collisionPoint.getX() >= this.regionP5.getX() && collisionPoint.getX() < this.regionP6.getX()) {
            v1 = Velocity.fromAngleAndSpeed(60, v2);
            return new Velocity(v1.getDx(), v1.getDy());
        }
            return new Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.rectangle.drawOn(d);
    }

    /**
     * This method updates the velocity by moving left.
     * @return The new velocity.
     */
    private Velocity leftV() {
        return new Velocity(-1 * this.move, 0);
    }

    /**
     * This method updates the velocity by moving right.
     * @return The new velocity.
     */
    private Velocity rightV() {
        return new Velocity(this.move, 0);
    }

    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        } else if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
    }
}