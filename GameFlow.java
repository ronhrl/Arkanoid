import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;
/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class GameFlow {

    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private int heightOfGui;
    private int widthOfGui;
    private GUI gui;

    /**
     * Constructor method.
     * @param animationRunner the animation that runs the game.
     * @param keyboardSensor the key board sensor of the game.
     * @param g the gui of the game.
     * @param height the height of the screen.
     * @param width the width of the screen.
     */
    public GameFlow(AnimationRunner animationRunner, KeyboardSensor keyboardSensor, GUI g, int height, int width) {
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.gui = g;
        this.score = new Counter(0);
        this.heightOfGui = height;
        this.widthOfGui = width;
    }

    /**
     * This method runs the levels.
     *
     * @param levels the levels we want to play.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, getAnimationRunner(), getKeyboardSensor(), getScore(),
                    this.heightOfGui, this.widthOfGui, this.gui);
            level.initialize();
            while (level.getBlockCount().getValue() > 0 && level.getBallCount().getValue() > 0) {
                level.run();
            }
            if (level.getBlockCount().getValue() == 0) {
                score.increase(100);
            }

            if (level.getBallCount().getValue() <= 0) {
                GameOver go  = new GameOver(this.score.getValue());
                endGame(go);
                return;
            }
        }
        WinScreen winScreen = new WinScreen(getScore().getValue());
        endGame(winScreen);
    }
/**
 * This method responsible for the end screen.
 * @param endScreen the end screen of the game.
 */

    public void endGame(Animation endScreen) {
        KeyPressStoppableAnimation keyPressStoppableAnimation = new KeyPressStoppableAnimation(getKeyboardSensor(),
                KeyboardSensor.SPACE_KEY, endScreen);
        getAnimationRunner().run(keyPressStoppableAnimation);
    }

    /**
     * This method gets the animation runner.
     * @return the animation runner.
     */
    public AnimationRunner getAnimationRunner() {
        return animationRunner;
    }

    /**
     * This method gets the keyboard sensor.
     * @return the keyboard sensor.
     */
    public KeyboardSensor getKeyboardSensor() {
        return keyboardSensor;
    }

    /**
     * This method gets score in the game.
     *
     * @return the score in the game.
     */
    public Counter getScore() {
        return score;
    }
    /**
     * This method gets the height of the gui.
     * @return the height of the gui.
     */
    public int getHeightOfGui() {
        return heightOfGui;
    }

    /**
     * This method gets the width of the gui.
     * @return the width of gui
     */
    public int getWidthOfGui() {
        return widthOfGui;
    }
}