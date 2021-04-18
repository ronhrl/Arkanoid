import biuoop.DrawSurface;

import java.awt.Color;


/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class Ball implements Sprite {
    private Point point;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private double startPointFrameX;
    private double startPointFrameY;
    private double endPointFrameX;
    private double endPointFrameY;

    /**
     * The Default end of frame.
     */
    static final int FRAME_END_DEFAULT = 400;
    /**
     * The Default start of frame.
     */
    static final int FRAME_START_DEFAULT = 0;

    /**
     * Constructor method.
     * @param center The center point of the ball.
     * @param r The radius of the ball.
     * @param color The color of the ball.
     * @param ge The game environment that includes all the blocks, paddle and balls.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment ge) {
        this.point = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = ge;
    }

    /**
     * another constructor method.
     * @param x The x value of the center point of the ball.
     * @param y The y value of the center point of the ball.
     * @param r The radius of the ball.
     * @param color The color of the ball.
     * @param ge The game environment of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment ge) {
        this.point = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.gameEnvironment = ge;
    }

    /**
     * This method uses the method getX from the Point class to get the x value of the center of the ball.
     * @return The x value of the center of the ball.
     */
    public double getX() {
        return this.point.getX();
    }

    /**
     * This method uses the method getY from the Point class to get the y value of the center of the ball.
     * @return The y value of the center of the ball.
     */
    public double getY() {
        return this.point.getY();
    }

    /**
     * This method gets the size of the ball that defined by its radius.
     * @return The radius of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * This method gets the color of the ball.
     * @return The color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * This method draw the ball on the drawing surface.
     * @param surface A drawing surface we want to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.point.getX(), (int) this.point.getY(), this.radius);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.point.getX(), (int) this.point.getY(), this.radius);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * This method sets the velocity of the ball.
     * @param v The velocity we want to give to the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * This method changes the ball velocity in another way.
     * @param dx The dx we want to give to the velocity of the ball.
     * @param dy The dy we want to give to the velocity of the ball.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * This method gets the velocity of the ball.
     * @return The velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * This method returns the center of the ball.
     * @return the center of the ball.
     */
    public Point getCenterBall() {
        return this.point;
    }

    /**
     * This method moves the ball one step.
     * the method first checks if there was any collision with a callable object.
     * if there was it changes the ball velocity and move the ball one step.
     * otherwise, it moves the ball one step in the same course.
     /* */
    public void moveOneStep() {
        if (this.velocity != null) {
            Line trajectory = new Line(this.getCenterBall(), this.getVelocity().applyToPoint(this.getCenterBall()));
            if (this.getGameEnvironment().getClosestCollision(trajectory) != null) {
                CollisionInfo c = this.getGameEnvironment().getClosestCollision(trajectory);
                changeBallCenter(this.getGameEnvironment().getClosestCollision(trajectory));
                Collidable rect = this.getGameEnvironment().getClosestCollision(trajectory).collisionObject();
                this.setVelocity(rect.hit(this, c.collisionPoint(), this.getVelocity()));
            } else {
                this.changeVelocity(this.checkIfBallStuckAxisX(), this.checkIfBallStuckAxisY());
            }
        }
    }
    /**
     * This method changes the values of the ball center.
     *
     * @param c the info about the collision that happened.
     */
    public void changeBallCenter(CollisionInfo c) {
        if (c.checkSideOfCollision().equals("upperLeft")) {
            this.point = new Point(c.collisionPoint().getX() - getSize(),
                    c.collisionPoint().getY() - getSize());
        } else if (c.checkSideOfCollision().equals("upperRight")) {
            this.point = new Point(c.collisionPoint().getX() + getSize(),
                    c.collisionPoint().getY() - getSize());
        } else if (c.checkSideOfCollision().equals("DownLeft")) {
            this.point = new Point(c.collisionPoint().getX() - getSize(),
                    c.collisionPoint().getY() + getSize());
        } else if (c.checkSideOfCollision().equals("downRight")) {
            this.point = new Point(c.collisionPoint().getX() + getSize(),
                    c.collisionPoint().getY() + getSize());
        } else if (c.checkSideOfCollision().equals("right")) {
            this.point = new Point(c.collisionPoint().getX() + getSize(),
                    c.collisionPoint().getY());
        } else if (c.checkSideOfCollision().equals("left")) {
            this.point = new Point(c.collisionPoint().getX() - getSize(),
                    c.collisionPoint().getY());
        } else if (c.checkSideOfCollision().equals("down")) {
            this.point = new Point(c.collisionPoint().getX(),
                    c.collisionPoint().getY() + getSize());
        } else if (c.checkSideOfCollision().equals("up")) {
            this.point = new Point(c.collisionPoint().getX(),
                    c.collisionPoint().getY() - getSize());
        }
    }

    /**
     * This method checks if the ball stuck in the y-axis.
     *
     * @return a boolean value.
     */
    public boolean checkIfBallStuckAxisY() {
        boolean isStuck = false;
        if (this.point.getY() - this.radius + this.velocity.getDy() < this.startPointFrameY) {
            isStuck = true;
            if (this.velocity.getDy() < 0) {
                // find the distance between the ball and the roof.
                double distance = this.point.getY() - this.startPointFrameY - this.radius;

                // according the distance to the roof move the ball. and change direction of the velocity.
                this.point = new Point(this.point.getX(),
                        this.point.getY() - this.velocity.getDy() - 2 * distance);
            } else {
                /// find the distance between the ball and the floor.
                double distance = this.endPointFrameY - this.point.getY() - this.radius;
                // according the distance to the floor move the ball. and change direction of the velocity.
                this.point = new Point(this.point.getX(), this.point.getY()
                        - this.velocity.getDy() + 2 * distance);
            }
        }
        return isStuck;
    }

    /**
     * This method checks if the ball stuck in the x-axis.
     *
     * @return a boolean value.
     */
    public boolean checkIfBallStuckAxisX() {
        boolean isStuck = false;
        if (this.point.getX() - this.radius + this.velocity.getDx() < this.startPointFrameX
                || this.point.getX() + this.radius + this.velocity.getDx() > this.endPointFrameX) {
            isStuck = true;
            if (this.velocity.getDx() < 0) {
                // find the distance between the ball and the left wall.
                double distance = this.point.getX() - this.startPointFrameX - this.radius;
                // according the distance to the left wall move the ball. and change direction of the velocity.
                this.point = new Point(this.point.getX() - this.velocity.getDx()
                        - 2 * distance, this.point.getY());
            } else {
                // find the distance between the ball and the right wall.
                double distance = this.endPointFrameX - this.point.getX() - this.radius;
                // according the distance to the right wall move the ball. and change direction of the velocity.
                this.point = new Point(this.point.getX() - this.velocity.getDx()
                        + 2 * distance, this.point.getY());
            }
        }
        return isStuck;
    }

    /**
     *This method changes the velocity, and the ball center values.
     *
     * @param axisX the axis x.
     * @param axisY the axis y.
     */
    public void changeVelocity(boolean axisX, boolean axisY) {
        //if the ball doesn't stuck in axis x or y - We will change this position by velocity.
        if (!axisY && !axisX) {
            this.point = this.velocity.applyToPoint(this.point);
        } else if (!axisY) { //if the ball doesn't stuck in axis y - change this position by getDx
            this.setVelocity(new Velocity(-this.velocity.getDx(), this.velocity.getDy()));
            this.point = new Point(this.point.getX(), this.point.getY()
                    + this.velocity.getDy());
        } else if (!axisX) { //if the ball doesn't stuck in axis x -  change this position by getDy
            this.setVelocity(new Velocity(this.velocity.getDx(), -this.velocity.getDy()));
            this.point = new Point(this.point.getX() + this.velocity.getDx(),
                    this.point.getY());
        } else { //if the ball stuck in both axis - change velocity in getDy and getDx
            this.setVelocity(new Velocity(-this.velocity.getDx(), -this.velocity.getDy()));
        }
    }
    /**
     * This method sets the frame gui.
     *
     * @param start the start of the gui.
     * @param end the end of the gui.
     */
    public void setFrameGui(Point start, Point end) {
        if (end != null && start != null) {
            if (start.getX() < 0) {
                System.out.println("Error: x1 is smaller than 0");
                this.startPointFrameX = FRAME_START_DEFAULT;
            }
            if (end.getX() < 0) {
                System.out.println("Error: y1 is smaller than 0");
                this.endPointFrameX = FRAME_END_DEFAULT;
            }
            if (start.getY() < 0) {
                System.out.println("Error: x2 is smaller than 0");
                this.startPointFrameY = FRAME_START_DEFAULT;
            }
            if (end.getY() < 0) {
                System.out.println("Error: y2 is smaller than 0");
                this.endPointFrameY = FRAME_END_DEFAULT;
            }
            this.startPointFrameX = Math.min(start.getX(), end.getX());
            this.startPointFrameY = Math.min(start.getY(), end.getY());
            this.endPointFrameX = Math.max(start.getX(), end.getX());
            this.endPointFrameY = Math.max(start.getY(), end.getY());
        }
        if (start == null) {
            this.startPointFrameX = FRAME_START_DEFAULT;
            this.startPointFrameY = FRAME_START_DEFAULT;
        }
        if (end == null) {
            this.endPointFrameX = FRAME_END_DEFAULT;
            this.endPointFrameY = FRAME_END_DEFAULT;
        }
    }

    /**
     * This method Sets the frame gui.
     *
     * @param x1 the x of the start point.
     * @param y1 the y of the start point.
     * @param x2 the x of the end point.
     * @param y2 the y of the end point.
     */
    public void setFrameGui(double x1, double y1, double x2, double y2) {
        if (x1 < 0) {
            System.out.println("Error: x1 is smaller than 0");
            x1 = FRAME_START_DEFAULT;
        }
        if (y1 < 0) {
            System.out.println("Error: y1 is smaller than 0");
            y1 = FRAME_START_DEFAULT;
        }
        if (x2 < 0) {
            System.out.println("Error: x2 is smaller than 0");
            x2 = FRAME_END_DEFAULT;
        }
        if (y2 < 0) {
            System.out.println("Error: y2 is smaller than 0");
            y2 = FRAME_END_DEFAULT;
        }
        setFrameGui(new Point(Math.min(x1, x2), Math.min(y1, y2)), new Point(Math.max(x1, x2), Math.max(y1, y2)));
    }


    /**
     * This method defines the velocities of the ball.
     * @param heightUp The upper size of the surface.
     * @param widthLeft The lefter size of the surface.
     * @param heightDown The lower size of the surface.
     * @param widthRight The righter size of the surface.
     */
    public void definesVelocities(int heightUp, int widthLeft, int heightDown, int widthRight) {
        this.setVelocity(velocity.getDx(), velocity.getDy());
        /*
        this if conditions checks is the ball is going to go outside the surface,
        if it does it change its velocity
         */
        if (this.getY() + this.getSize() + velocity.getDy() >= heightDown && velocity.getDy() > 0) {
            Velocity v1 = new Velocity(velocity.getDx(), -1 * velocity.getDy());
            this.setVelocity(v1);
        }
        if (this.getY() - this.getSize() + velocity.getDy() <= heightUp && velocity.getDy() < 0) {
            Velocity v1 = new Velocity(velocity.getDx(), -1 * velocity.getDy());
            this.setVelocity(v1);
        }
        if (this.getX() + this.getSize() + velocity.getDx() >= widthRight && velocity.getDx() > 0) {
            Velocity v1 = new Velocity(-1 * velocity.getDx(), velocity.getDy());
            this.setVelocity(v1);
        }
        if (this.getX() - this.getSize() + velocity.getDx() <= widthLeft && velocity.getDx() < 0) {
            Velocity v1 = new Velocity(-1 * velocity.getDx(), velocity.getDy());
            this.setVelocity(v1);
        }
    }

    /**
     * This method set the game environment of the ball.
     * @param ge The game environment we want to set to.
     */
    public void setGameEnvironment(GameEnvironment ge) {
        this.gameEnvironment = ge;
    }

    /**
     * This method returns the game environment of the ball.
     * @return The game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * This method adds the ball as a sprite to the game.
     * @param g The game we want to add ths ball to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * This method removes the ball from the game.
     * @param ge The game we want to remove the ball from.
     */
    public void removeFromGame(GameLevel ge) {
        ge.removeSprite(this);
    }
}