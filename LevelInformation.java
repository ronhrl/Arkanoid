import java.util.List;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */


public interface LevelInformation {
        /**
         * the number of balls in the level.
         * @return the number of balls.
         */
        int numberOfBalls();

        /**
         * This method initial velocity of each ball.
         * @return list of the balls velocities.
         */
        List<Velocity> initialBallVelocities();

        /**
         * This method defines the speed of the paddle.
         * @return the speed of the paddle.
         */
        int paddleSpeed();

        /**
         * This method defines the width of the paddle.
         * @return the width of the paddle.
         */
        int paddleWidth();

        /**
         * This method defines the name that will be displayed at the top of the screen.
         * @return the level name.
         */
        String levelName();

        /**
         * This method returns a sprite with the background of the level.
         * @return a sprite with the background of the level.
         */
        Sprite getBackground();

        /**
         * This method creates The Blocks that make up this level,
         * each block contains its size, color and location.
         * @return list of all the blocks in the game.
         */
        List<Block> blocks();
        /**
         * This method defines how many blocks should be removed
         * before the level is considered to be "cleared".
         * @return the number of blocks that need to be removed.
         */
        int numberOfBlocksToRemove();
}