package CarLab;

import java.awt.*;

// TODO: Override toString method for the cars!

public abstract class Car implements Movable {

    private double x;
    private double y;
    private DIRECTION direction;
    private boolean engineOn;

    protected int nrDoors; // Number of doors on the car
    protected double currentSpeed;
    protected double enginePower; // Engine power of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    public Car() {
        this.x = 0;
        this.y = 0;
        this.direction = DIRECTION.NORTH;
        this.engineOn = false;
    }
    protected double speedFactor() {
        return 0;
    }
    // Tested
    public int getNrDoors() {
        return nrDoors;
    }
    // Tested
    public double getEnginePower() {
        return enginePower;
    }
    // Tested
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public boolean getEngineOn() {
        return engineOn;
    }

    /**
     * Gets the current coordinate in doubles.
     *
     * @return Integer array of coordinate x and y [-,+].
     */
    public Double[] getCoordinate() {
        return new Double[]{this.x, this.y};
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
        engineOn = true;
    }

    public void stopEngine() {
        currentSpeed = 0;
        engineOn = false;
    }

    /**
     * Move x or y in direction based on DIRECTION of instance Car. Positive y is north, positive x is east.
     */
    @Override
    public void move() {
        if (direction == DIRECTION.NORTH) {
            y += getCurrentSpeed();
        } else if (direction == DIRECTION.EAST) {
            x += getCurrentSpeed();
        } else if (direction == DIRECTION.SOUTH) {
            y -= getCurrentSpeed();
        } else if (direction == DIRECTION.WEST) {
            x -= getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft() {
        direction = direction.left(direction);
    }

    @Override
    public void turnRight() {
        direction = direction.right(direction);
    }


    /**
     * Increments speed based on class-factors.
     *
     * @param amount is the positive amount to increase.
     */
    protected abstract void incrementSpeed(double amount);

    /**
     * Decreases speed based on class-factors. Should not change speed to go below zero.
     *
     * @param amount is the positive amount to decrease.
     */
    protected abstract void decrementSpeed(double amount);

    /**
     * Gas method will accelerate with increaseSpeed() but only if engine is on.
     *
     * @param amount is the positive amount [0,1] to accelerate, is multiplied with speedFactor in incrementSpeed.
     */
    public void gas(double amount) {
        if(1 - amount < 0 || 1 - amount > 1) {
            throw new IllegalArgumentException("Gas amount should be within [0,1]");
        }
        if (engineOn) {
            incrementSpeed(amount);
        }
    }

    /**
     * Brake method will decelerate with decrementSpeed().
     *
     * @param amount is the positive amount [0,1] to decelerate, is multiplied with speedFactor in decrementSpeed.
     */
    public void brake(double amount) {
        if(1 - amount < 0 || 1 - amount > 1) {
            throw new IllegalArgumentException("Brake amount should be within [0,1]");
        }
        if(amount > currentSpeed)
            amount = currentSpeed;
        decrementSpeed(amount);
    }

    /**
     * Direction enum with NORTH, EAST, SOUTH, and WEST. The methods right() and left() should wrap around the
     * directions (West goes to North, and North goes to West).
     */
    public enum DIRECTION {
        NORTH, EAST, SOUTH, WEST;

        private static DIRECTION[] directionValues = values();

        public DIRECTION right(DIRECTION direction) {
            return directionValues[(direction.ordinal() + 1) % directionValues.length];
        }

        public DIRECTION left(DIRECTION direction) {
            if (direction.equals(NORTH)){
                return WEST;
            } else {
                return directionValues[(direction.ordinal() - 1)];
            }
        }
    }
}
