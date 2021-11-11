package src;

import java.awt.*;

// TODO: Override toString method for the cars!

public abstract class Car implements Movable {

    private int x;
    private int y;

    protected int nrDoors; // Number of doors on the car
    protected double currentSpeed;
    protected double enginePower; // Engine power of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected double speedFactor() {
        return 0;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }
}
