package CarLab;

import java.awt.*;

public class RunCars {
    public static void main(String[] arg) {
        Volvo240 volvo = new Volvo240(Color.BLUE);
        Saab95 saab = new Saab95(Color.BLACK);

        System.out.println("Cars: " + volvo + " " + saab);
    }
}
