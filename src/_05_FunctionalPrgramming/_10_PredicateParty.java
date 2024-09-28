package _05_FunctionalPrgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        List<String> names = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String[] input = sc.nextLine().split("\\s+");

        while (!input[0].equals("Party!")) {
            String command = input[0];
            String condition = input[1];
            String argument = input[2];

            Predicate<String> predicate = getPredicate(condition, argument);

            switch (command) {
                case "Remove" -> names.removeIf(predicate);
                case "Double" -> {
                    List<String> namesToAdd = new ArrayList<>();
                    for (String name : names) {
                        if (predicate.test(name)) {
                            namesToAdd.add(name);
                        }
                    }
                    names.addAll(namesToAdd);
                }
            }
            input = sc.nextLine().split("\\s+");
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(names.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String condition, String argument) {
        return switch (condition) {
            case "StartsWith" -> name -> name.startsWith(argument);
            case "EndsWith" -> name -> name.endsWith(argument);
            case "Length" -> name -> name.length() == Integer.parseInt(argument);
            default -> throw new IllegalStateException("Unexpected value: " + condition);
        };
    }
}