import java.util.ArrayList;
import java.util.List;

/**
 * @author ID 308433762
 * version 1
 * since 31/05/2020
 */

public class Green3 extends AllLevels {
    /**
     * The how many blocks in line.
     */
    static final int HOW_MANY_BLOCKS_LINE = 5;
    /**
     * The distance from the y upper limit.
     */
    static final int DISTANCE_FROM_THE_Y_UPPER_LIMIT = 180;
    /**
     * The number of blocks that decrease each line.
     */
    static final int NUMBER_OF_BLOCKS_THAT_DECREASE_EACH_LINE = 1;
    /**
     * The width of block.
     */
    static final double WIDTH_OF_BLOCK = 50;
    /**
     * The height of block.
     */
    static final double HEIGHT_OF_BLOCK = 20;
    /**
     * The size of block frame.
     */
    static final int SIZE_OF_BLOCK_FRAME = 10;
    /**
     * The speed of the ball.
     */
    static final int BALL_SPEED = 5;

    /**
     * Constructor method.
     * @param width the width of the screen.
     * @param height the height of the screen.
     */
    public Green3(int width, int height) {
        super(width, height);
    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>(this.numberOfBalls());
        velocityList.add(Velocity.fromAngleAndSpeed(50, BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(300, BALL_SPEED));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 120;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Sprite green3 = new Green3BackGround(getWidthOfScreen() , getHeightOfScreen());
        return green3;
    }
    @Override
    public List<Block> blocks() {
        Point tempP;
        Block block;
        List<Block> blockList = new ArrayList<>();
        int numBlocksInTopLine = 10;
        double xStartOfBlocks = getWidthOfScreen() - SIZE_OF_BLOCK_FRAME - (2 * WIDTH_OF_BLOCK) + 50;
        for (int j = 0; j < HOW_MANY_BLOCKS_LINE; j++) {
            for (int i = 0; i < numBlocksInTopLine - (j * NUMBER_OF_BLOCKS_THAT_DECREASE_EACH_LINE); i++) {
                tempP = new Point(xStartOfBlocks - i * WIDTH_OF_BLOCK, (j * HEIGHT_OF_BLOCK)
                        + DISTANCE_FROM_THE_Y_UPPER_LIMIT);
                //top line
                Rectangle rec = new Rectangle(tempP, WIDTH_OF_BLOCK, HEIGHT_OF_BLOCK, getAllColors()[j]);
                block = new Block(rec);
                blockList.add(block);
            }
        }
        return blockList;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}