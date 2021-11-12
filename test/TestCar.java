import CarLab.Car;
import CarLab.Saab95;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestCar {

    @Test
    public void test_turn_left() {
        Car saab95 = new Saab95(Color.black);
        saab95.turnLeft();
        assertEquals(Car.DIRECTION.WEST, saab95.getDirection());
    }

    @Test
    public void test_turn_right() {
        Car saab95 = new Saab95(Color.black);
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        assertEquals(Car.DIRECTION.NORTH, saab95.getDirection());
    }

    @Test
    public void should_move_on_y_axis_only_from_zero() {
        Car saab95 = new Saab95(Color.BLACK);
        saab95.startEngine();
        saab95.move();
        assertNotEquals(0, saab95.getCoordinate()[1]);
        assertEquals(0, saab95.getCoordinate()[0]);
    }

    @Test
    public void should_move_on_x_axis_only_from_zero() {
        Car saab95 = new Saab95(Color.BLACK);
        saab95.startEngine();
        saab95.turnRight();
        saab95.move();
        assertNotEquals(0, saab95.getCoordinate()[0]);
        assertEquals(0, saab95.getCoordinate()[1]);
    }

    @Test
    public void engine_power_should_not_be_zero_nor_negative(){
        Car saab95 = new Saab95(Color.BLACK);
        double testingFactor = Math.abs(saab95.getEnginePower());
        assertNotEquals(0, saab95.getEnginePower());
        assertEquals(0, saab95.getEnginePower() - testingFactor);
    }

    @Test
    public void number_of_doors_should_not_be_zero_nor_negative(){
        Car saab95 = new Saab95(Color.BLACK);
        double testingFactor = Math.abs(saab95.getNrDoors());
        assertNotEquals(0, saab95.getNrDoors());
        assertEquals(0, saab95.getNrDoors() - testingFactor);
    }

    @Test
    public void current_speed_should_not_be_zero_nor_negative_while_moving(){
        Car saab95 = new Saab95(Color.BLACK);
        saab95.startEngine();
        saab95.gas(1);
        saab95.move();
        double testingFactor = Math.abs(saab95.getCurrentSpeed());
        assertNotEquals(0, saab95.getCurrentSpeed());
        assertEquals(0, saab95.getCurrentSpeed() - testingFactor);
    }

    @Test
    public void current_speed_should_be_01_when_engine_is_started(){
        Car saab95 = new Saab95(Color.BLACK);
        saab95.startEngine();
        assertEquals(0.1, saab95.getCurrentSpeed());
    }

    @Test
    public void car_should_have_a_colour(){
        Car saab95 = new Saab95();
        saab95.setColor(Color.BLACK);
        assertEquals(saab95.getColor().toString(), "BLACK");
    }

}
