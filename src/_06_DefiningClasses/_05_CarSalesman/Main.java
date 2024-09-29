package _06_DefiningClasses._05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int engineCount = Integer.parseInt(sc.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < engineCount; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            Engine engine = getEngine(tokens);
            engines.add(engine);
        }

        int carsCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < carsCount; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            Engine carEngine = getEngineByName(engines, tokens[1]); // Find the corresponding engine
            Car car = getCar(tokens, carEngine);
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }

    }

    private static Engine getEngine(String[] tokens) {
        String engineModel = tokens[0];
        int enginePower = Integer.parseInt(tokens[1]);

        String engineDisplacement = "";
        String engineEfficiency= "";

        switch (tokens.length) {
            case 3 -> {
                if(tokens[2].matches("\\d+")){
                    engineDisplacement = tokens[2];
                } else {
                    engineEfficiency = tokens[2];
                }
            }
            case 4 -> {
                engineDisplacement = tokens[2];
                engineEfficiency = tokens[3];
            }
        }
        return new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
    }

    private static Car getCar(String[] tokens, Engine engine) {
        String model = tokens[0];
        String weight = "";
        String color = "";

        switch (tokens.length){
            case 3 -> {
                if(tokens[2].matches("\\d+")){
                    weight = tokens[2];
                } else {
                    color = tokens[2];
                }
            }
            case 4 -> {
                weight = tokens[2];
                color = tokens[3];
            }
        }

        return new Car(model, engine, weight, color);
    }

    private static Engine getEngineByName(List<Engine> engines, String name) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(name)) {
                return engine;
            }
        }
        return null;
    }
}
