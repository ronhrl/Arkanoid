import java.util.ArrayList;
import java.util.List;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */


public class DirectHit extends AllLevels {

    static final int BALL_SPEED = 7;
    /**
     * Constructor method.
     * @param width the width of the screen.
     * @param height the height of the scree.
     */
    public DirectHit(int width, int height) {
        super(width , height);
    }

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(360, BALL_SPEED));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 8;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Sprite directHitBg =  new DirectHitBackGround(getWidthOfScreen(), getHeightOfScreen());
        return directHitBg;
    }

    @Override
    public List<Block> blocks() {
        List<Block> b = new ArrayList<>();
        int blockHeight = 30;
        int blockWidth = 30;
        Rectangle rec = new Rectangle(new Point((getWidthOfScreen() / 2.0) - blockHeight / 2.0,
                150 - blockHeight / 2.0), blockWidth, blockHeight, getAllColors()[0]);
        Block b1 = new Block(rec);
        b.add(b1);
        return b;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}