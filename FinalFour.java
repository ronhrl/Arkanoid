//import Point;

import java.util.ArrayList;
import java.util.List;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */


public class FinalFour extends AllLevels {
    /**
     * The width of the block.
     */
    static final double WIDTH_OF_BLOCK = 51;
    /**
     * The height of the block.
     */
    static final double HEIGHT_OF_BLOCK = 25;

    /**
     * Constructor method.
     * @param width the width of the screen.
     * @param height the height of the screen.
     */
    public FinalFour(int width, int height) {
        super(width, height);
    }

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        int speed = 5 , angle1 = 340, angle2 = 360, angle3 = 380;
        velocityList.add(Velocity.fromAngleAndSpeed(angle1 , speed));
        velocityList.add(Velocity.fromAngleAndSpeed(angle2 , speed));
        velocityList.add(Velocity.fromAngleAndSpeed(angle3 , speed));
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Sprite finalF =  new FinalFourBackGrounds(getWidthOfScreen() , getHeightOfScreen());
        return finalF;
    }

    @Override
    public List<Block> blocks() {
        Point tempP;
        Block block;
        List<Block> blockList = new ArrayList<>();
        for (int j = 100; j < 250; j += HEIGHT_OF_BLOCK) {
            for (int i = 20; i <= getWidthOfScreen() - WIDTH_OF_BLOCK; i += WIDTH_OF_BLOCK) {
                tempP = new Point(i, j);
                Rectangle rec = new Rectangle(tempP, WIDTH_OF_BLOCK - 1, HEIGHT_OF_BLOCK, getAllColors()[j % 7]);
                block = new Block(rec);
                blockList.add(block);
            }
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 90;
    }
}