package _06_DefiningClasses._04_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            Car car = getCar(tokens);
            cars.add(car);
        }

        String type = sc.nextLine();
        if (type.equals("fragile")) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals(type) && car.getTire().hasLowPressure()) {
                    System.out.println(car.getModel());
                }
            }
        } else {
            for (Car car : cars) {
                if (car.getCargo().getType().equals(type) && car.getEngine().isTooPowerfull()) {
                    System.out.println(car.getModel());
                }
            }
        }
    }

    private static Car getCar(String[] tokens) {
        String model = tokens[0];
        int engineSpeed = Integer.parseInt(tokens[1]);
        int enginePower = Integer.parseInt(tokens[2]);
        int cargoWeight = Integer.parseInt(tokens[3]);
        String cargoType = tokens[4];
        double tirePressure1 = Double.parseDouble(tokens[5]);
        int tireAge1 = Integer.parseInt(tokens[6]);
        double tirePressure2 = Double.parseDouble(tokens[7]);
        int tireAge2 = Integer.parseInt(tokens[8]);
        double tirePressure3 = Double.parseDouble(tokens[9]);
        int tireAge3 = Integer.parseInt(tokens[10]);
        double tirePressure4 = Double.parseDouble(tokens[11]);
        int tireAge4 = Integer.parseInt(tokens[12]);

        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Tire tire = new Tire(tirePressure1, tireAge1, tirePressure2, tireAge2,
                tirePressure3, tireAge3, tirePressure4, tireAge4);

        return new Car(model, engine, cargo, tire);
    }
}
