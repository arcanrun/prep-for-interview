package hw01.task03;

import static java.lang.Math.*;

public class Triangle implements Figure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = (a + b + c) / 2;
        return sqrt(
                (p - a) * (p - b) * (p - c)
        );
    }
}
