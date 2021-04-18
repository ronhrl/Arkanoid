import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class WideEasy extends AllLevels {
    /**
     * The Angle for start.
     */
    static final double FIRST_ANGLE = 260;
    /**
     * The Speed of ball.
     */
    static final double BALL_SPEED = 5;
    /**
     * The X start of line.
     */
    static final int THE_X_OF_START_LINE = 20;
    /**
     /**
     * The Width of block.
     */
    static final double BLOCK_WIDTH = (154 / 3.0);
    /**
     * The Height of block.
     */
    static final double BLOCK_HEIGHT = 20;
    /**
     * The Y end of line.
     */
    static final double Y_END_OF_LINE = 250;


    /**
     * Constructor method.
     * @param width the width of the screen.
     * @param height the height of the screen.
     */
    public WideEasy(int width, int height) {
        super(width, height);
    }

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        double angle = FIRST_ANGLE;
        for (int i = 0; i < numberOfBalls(); i++) {
            velocityList.add(Velocity.fromAngleAndSpeed(angle, BALL_SPEED));
            angle = angle + 20;
            if (angle >= 340 && angle <=  380) {
                angle = angle + 10;
            }
        }
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Easy";

    }

    @Override
    public Sprite getBackground() {
        Sprite wideBg =  new WideEasyBackGround(800, 600);
        return wideBg;
    }

    @Override
    public List<Block> blocks() {
        Point tempP;
        Block block;
        int countForColorOfBlocks = 1;
        List<Block> blockList = new ArrayList<>();
        for (int i = THE_X_OF_START_LINE; i <= getWidthOfScreen() - BLOCK_WIDTH; i += BLOCK_WIDTH) {
            tempP = new Point(i , Y_END_OF_LINE);
            Rectangle rectangle = new Rectangle(tempP, BLOCK_WIDTH - 0.7 , BLOCK_HEIGHT,
                    chooseColorAccordingToLocation(countForColorOfBlocks));
            block = new Block(rectangle);
            countForColorOfBlocks += 1;
            blockList.add(block);
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
    /**
     * Peak color according to location color.
     *
     * @param indexOfBlock the index of block
     * @return the color
     */
    private Color chooseColorAccordingToLocation(int indexOfBlock) {
        switch (indexOfBlock) {
            case 1:
            case 2:
                return Color.red;
            case 3:
            case 4:
                return new Color(255, 204, 51);
            case 5:
            case 6:
                return Color.yellow;
            case 7:
            case 8:
            case 9:
                return new Color(0, 204, 0);
            case 10:
            case 11:
                return new Color(0, 0, 204);
            case 12:
            case 13:
                return new Color(153, 102, 0);
            case 14:
            case 15:
                return new Color(51, 204, 255);
            default:
                break;

        }
        return Color.LIGHT_GRAY;
    }
}