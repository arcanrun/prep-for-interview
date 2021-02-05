package hw01.task02;

import hw01.task02.engine.LightWeighCarEngine;
import hw01.task02.engine.LorryEngine;

public class Main {
    public static void main(String[] args) {
        Car lwc = new LightWeightCar();
        lwc.setEngine(new LightWeighCarEngine());
        lwc.start();
        lwc.stop();

        Car lorry = new Lorry();
        lorry.setEngine(new LorryEngine());
        lorry.start();
        lorry.stop();
    }
}
