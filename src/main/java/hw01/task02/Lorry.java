package hw01.task02;

class Lorry extends Car {


    @Override
    void open() {
        System.out.println("Lorry is opened");
    }

    @Override
    public void move() {
        engine.igntie();
        System.out.println("Lorry is moving");
    }

    @Override
    public void stop() {
        System.out.println("Lorry is stoped");
    }
}
