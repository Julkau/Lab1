package src;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(Color color) {
        nrDoors = 2;
        this.color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "src.Saab95";
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}