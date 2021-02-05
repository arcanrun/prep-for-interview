package hw01.task03;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[3];

        figures[0] = new Circle(2);
        figures[1] = new Square(3);
        figures[2] = new Triangle(3, 2, 3);

        for (Figure f : figures) {
            System.out.println(f.getClass().getSimpleName() + ": " + f.area());
        }
    }
}
