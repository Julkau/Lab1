package CarLab;

/**
 * Only public methods should be here, stuff we would like to call from another class to move the Car (or other type that
 * implements Movable).
 */

public interface Movable {

    /**
     * Increments speed based on class-factors.
     * @param amount is the positive amount to increase.
     */
    void incrementSpeed(double amount);

    /**
     * Decreses speed based on class-factors. Should not change speed to go below zero.
     * @param amount is the positive amount to decrease.
     */
    void decrementSpeed(double amount);

    void move();

    void turnRight();

    void turnLeft();
}
