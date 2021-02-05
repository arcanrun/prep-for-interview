package hw01.task02;

class LightWeightCar extends Car {


    @Override
    void open() {
        System.out.println("LightWeightCar is opend");
    }

    @Override
    public void move() {
        engine.igntie();
        System.out.println("LightWeightCar is moving");
    }

    @Override
    public void stop() {
        System.out.println("LightWeightCar is stoped");

    }
}
