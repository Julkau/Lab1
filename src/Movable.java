package src;

/**
 * Only public methods should be here, stuff we would like to call from another class to move the Car (or other type that
 * implements Movable).
 */

public interface Movable {

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    void move();

    void turnRight();

    void turnLeft();
}
