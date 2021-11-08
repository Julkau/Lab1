package src;

public interface Movable {

    double currentSpeed = 0; // The current speed of the car
    
    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    void move();

    void turnRight();

    void turnLeft();

    // TODO fix this method according to lab pm
    void gas(double amount);

    // TODO fix this method according to lab pm
    void brake(double amount);
}
