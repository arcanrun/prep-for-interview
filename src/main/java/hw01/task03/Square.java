package hw01.task03;

import static java.lang.Math.*;

public class Square implements Figure {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return pow(side, 2);
    }
}
