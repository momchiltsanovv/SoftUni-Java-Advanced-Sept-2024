package _06_DefiningClasses._05_CarSalesman;

public class Car {

    private final String model;
    private final Engine engine;
    private final String weight;
    private final String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight.isEmpty() ? "n/a" : weight;
        this.color = color.isEmpty() ? "n/a" : color;
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s\nWeight: %s\nColor: %s",
                model, engine.toString(), weight, color);
    }
}
