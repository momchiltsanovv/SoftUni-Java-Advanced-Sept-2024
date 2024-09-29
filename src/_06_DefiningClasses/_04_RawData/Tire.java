package _06_DefiningClasses._04_RawData;

public class Tire {

    private double[] pressures;
    private int[] ages;

    public Tire(double pressure1, int age1, double pressure2, int age2,
                double pressure3, int age3, double pressure4, int age4) {
        this.pressures = new double[]{pressure1, pressure2, pressure3, pressure4};
        this.ages = new int[]{age1, age2, age3, age4};
    }

    public boolean hasLowPressure() {
        for (double pressure : pressures) {
            if (pressure < 1) {
                return true;
            }
        }
        return false;
    }

}
