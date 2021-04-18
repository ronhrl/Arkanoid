import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Constructor method.
     *
     * @param sensor the sensor.
     * @param key the key that pressed.
     * @param animation the animation of the game.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        stop = false;
        isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(getKey())) {
            if (!isAlreadyPressed()) {
                this.stop = true;
            }
        } else {
            setAlreadyPressed(false);
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * This method gets the sensor.
     *
     * @return the sensor.
     */
    public KeyboardSensor getSensor() {
        return sensor;
    }

    /**
     * This method gets the key.
     *
     * @return the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * This method gets the animation.
     *
     * @return the animation.
     */
    public Animation getAnimation() {
        return animation;
    }

    /**
     * This method checks if the key is already pressed.
     *
     * @return the boolean value.
     */
    public boolean isAlreadyPressed() {
        return this.isAlreadyPressed;
    }

    /**
     * This method sets already pressed.
     * @param alreadyPressed the already pressed boolean value.
     */
    public void setAlreadyPressed(boolean alreadyPressed) {
        this.isAlreadyPressed = alreadyPressed;
    }
}