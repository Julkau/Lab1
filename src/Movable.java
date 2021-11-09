package src;

public interface Movable {

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    void move();

    void turnRight();

    void turnLeft();

    void startEngine();

    void stopEngine();

    void gas(double amount);

    void brake(double amount);

}
