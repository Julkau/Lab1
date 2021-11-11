package src;

import java.awt.*;

// TODO: Override toString method for the cars!

public abstract class Car implements Movable {

    private double x;
    private double y;
    private DIRECTION direction;


    protected int nrDoors; // Number of doors on the car
    protected double currentSpeed;
    protected double enginePower; // Engine power of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    public Car(){
        this.x = 0;
        this.y = 0;
        this.direction = DIRECTION.NORTH;
    }

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

    /**
     * Gets the current coordinate in ints.
     * @return Integer array of coordinate x and y [-,+].
     */
    public Double[] getCoordinate() {
        return new Double[]{this.x, this.y};
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

    /**
     * Move x or y in direction based on DIRECTION of instance Car. Positive y is north, positive x is east.
     */
    @Override
    public void move() {
        if(this.direction == DIRECTION.NORTH) {
            y += getCurrentSpeed();
        } else if (this.direction == DIRECTION.EAST) {
            x += getCurrentSpeed();
        } else if (this.direction == DIRECTION.SOUTH) {
            x -= getCurrentSpeed();
        } else if (this.direction == DIRECTION.WEST) {
            x -= getCurrentSpeed();
        }

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

    enum DIRECTION {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
}
