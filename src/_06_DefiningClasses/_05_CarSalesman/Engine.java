package _06_DefiningClasses._05_CarSalesman;

public class Engine {

    private final String model;
    private final int power;
    private final String displacement;
    private final String efficiency;

    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement.isEmpty() ? "n/a" : displacement;
        this.efficiency = efficiency.isEmpty() ? "n/a" : efficiency;
    }


    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:\nPower: %d\nDisplacement: %s\nEfficiency: %s",
                model, power, displacement, efficiency);
    }
}
