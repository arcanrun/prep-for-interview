package hw01.task03;

import static java.lang.Math.*;

public class Circle implements Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * pow(radius, 2);
    }
}
