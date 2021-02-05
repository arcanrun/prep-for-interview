package hw01.task02;

import hw01.task02.engine.Engine;

abstract class Car implements Moveable, Stopable{
    public Engine engine;
    private String color;
    private String name;


    protected void start() {
        open();
        move();
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
