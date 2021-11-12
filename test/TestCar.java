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
}
