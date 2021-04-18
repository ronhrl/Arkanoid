/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class Counter {

    private int n;

    /**
     * Constructor method.
     * @param num The num we want to put in the counter.
     */
    public Counter(int num) {
        this.n = num;
    }

    /**
     * This method increases the counter.
     * @param number The number we want to increase the counter by.
     */
    public void increase(int number) {
        this.n += number;
    }

    /**
     * This method decreases the counter.
     * @param number The number we want to decrease the counter by.
     */
    public void decrease(int number) {
        this.n -= number;
    }

    /**
     * This method gets the value of the counter.
     * @return The value of the counter.
     */
    public int getValue() {
        return this.n;
    }
}