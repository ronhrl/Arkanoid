import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockCount;
    private Counter ballCount;
    private Counter score;
    private BlockRemover br;
    private BallRemover ballRe;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInf;
    private Paddle paddle;
    private int widthOfScreen;
    private int heightOfScreen;

    /**
     * The size of the block frame.
     */
    static final int SIZE_OF_BLOCK_FRAME = 20;
    /**
     * The space paddle from balls.
     */
    static final double SPACE_PADDLE_FROM_BALLS = 10;
    /**
     * The radius of ball.
     */
    static final int RADIUS_OF_BALL = 7;
    /**
     * The color of balls.
     */
    static final Color COLOR_OF_BALLS = Color.white;

    /**
     * Constructor method.
     * @param levelInf the information about the level.
     * @param animationRun the animation that runs the game.
     * @param keyboard the keyboard of the game.
     * @param score the score in the game.
     * @param height the height of the screen.
     * @param width the width of the screen.
     * @param g the gui.
     */
    public GameLevel(LevelInformation levelInf, AnimationRunner animationRun, KeyboardSensor keyboard, Counter score,
                     int height, int width, GUI g) {
        this.gui = g;
        this.environment = new GameEnvironment();
        this.levelInf = levelInf;
        this.blockCount = new Counter(levelInf.numberOfBlocksToRemove());
        this.ballCount = new Counter(levelInf.numberOfBalls());
        this.br = new BlockRemover(this, blockCount);
        this.ballRe = new BallRemover(this, ballCount);
        this.score = score;
        this.runner = animationRun;
        this.running = true;
        this.keyboard = keyboard;
        this.widthOfScreen = width;
        this.heightOfScreen = height;
    }

    /**
     * This method gets the width of the screen.
     * @return the width of the screen.
     */
    public int getWidthOfScreen() {
        return widthOfScreen;
    }

    /**
     * This method gets the height of the screen.
     * @return the height of the screen.
     */
    public int getHeightOfScreen() {
        return heightOfScreen;
    }

    /**
     * This method gets the game environment.
     * @return the game environment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * This method adds collidables to the game environment.
     *
     * @param c The collidable we want to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * This method adds sprites to the game.
     *
     * @param s The sprite we want to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * This method adds blocks to the game.
     */
    public void addBlocksToGame() {
        List<Block> blockList = new ArrayList<>(this.levelInf.blocks());
        ScoreTrackingListener scoreTrack = new ScoreTrackingListener(this.score);
        ScoreIndicator sc = new ScoreIndicator(scoreTrack);
        sc.addToGame(this);
        /*
        this loop adds the blocks to game in an order.
         */
        for (Block block : blockList) {
            block.addToGame(this);
            block.addHitListener(br);
            block.addHitListener(scoreTrack);
        }
    }

    /**
     * This method initializes the game.
     */
    public void initialize() {
        this.sprites.addSprite(this.levelInf.getBackground());
        double paddleSpeed = this.levelInf.paddleSpeed();
        Point p4 = new Point((getWidthOfScreen() / 2.0) - this.levelInf.paddleWidth() / 2.0,
                getHeightOfScreen() - 30);
        addBlocksToGame();
        Rectangle rectanglePad = new Rectangle(p4, this.levelInf.paddleWidth(), 10, Color.green);
        this.paddle = new Paddle(rectanglePad, 785, keyboard, paddleSpeed);
        paddle.addToGame(this);
        Rectangle rectangle1 = new Rectangle(new Point(0, 24), 800, 20, Color.gray);
        Rectangle rectangle2 = new Rectangle(new Point(0, 24), 20, 580, Color.gray);
        Rectangle rectangle3 = new Rectangle(new Point(780, 24), 20, 580, Color.gray);
        Block block1 = new Block(rectangle1);
        Block block2 = new Block(rectangle2);
        Block block3 = new Block(rectangle3);
        this.addSprite(block1);
        this.addSprite(block2);
        this.addSprite(block3);
        createBallsOnTopOfPaddle();
        Rectangle deathRec = new Rectangle(new Point(20.9, 599), 759, 1, Color.gray);
        Block deathBlock = new Block(deathRec);
        deathBlock.addToGame(this);
        deathBlock.addHitListener(ballRe);
        LevelNameOnScreen levelNameOnScreen = new LevelNameOnScreen(levelInf);
        levelNameOnScreen.addToGame(this);
    }

    /**
     * This method runs the game.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(4, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * This method creates the balls on the top of the paddle.
     */
    public void createBallsOnTopOfPaddle() {
        Ball[] ballArray = new Ball[this.levelInf.numberOfBalls()];
        Point centerBall = new Point(this.paddle.getCollisionRectangle().getUpperRight().getX()
                - (this.paddle.getCollisionRectangle().getWidth() / 2),
                this.paddle.getCollisionRectangle().getUpperRight().getY() - SPACE_PADDLE_FROM_BALLS);

        for (int i = 0; i < this.levelInf.numberOfBalls(); i++) {
            ballArray[i] = new Ball(centerBall, RADIUS_OF_BALL, COLOR_OF_BALLS, getEnvironment());
            ballArray[i].setFrameGui(SIZE_OF_BLOCK_FRAME, SIZE_OF_BLOCK_FRAME * 2,
                    getWidthOfScreen() - SIZE_OF_BLOCK_FRAME, getHeightOfScreen());
            ballArray[i].setVelocity(this.levelInf.initialBallVelocities().get(i));
            ballArray[i].setGameEnvironment(this.environment);
            ballArray[i].addToGame(this);
        }
    }

    /**
     * This method removes the collidable objects from the game.
     *
     * @param c The collidable object we want to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidableGe(c);
    }

    /**
     * This method removes the collidable objects from the game.
     *
     * @param s The sprite we want to remove from the game.
     */
    public void removeSprite(Sprite s) {
        SpriteCollection spriteCopy = this.sprites;
        spriteCopy.removeSpriteCol(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.blockCount.getValue() == 0) {
            this.running = false;
        }
        if (this.ballCount.getValue() == 0) {
            this.running = false;
        }

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
    }

    /**
     * This method gets the count of the blocks.
     * @return the count of the blocks.
     */
    public Counter getBlockCount() {
        return this.blockCount;
    }

    /**
     * this method gets the count of balls.
     * @return the count of the balls.
     */
    public Counter getBallCount() {
        return this.ballCount;
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}