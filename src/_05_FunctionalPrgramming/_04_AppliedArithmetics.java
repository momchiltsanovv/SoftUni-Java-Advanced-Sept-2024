package _05_FunctionalPrgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.System.in;

public class _04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();


        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(n -> n + 1).toList();
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(n -> n - 1).toList();
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(n -> n * 2).toList();

        Consumer<List<Integer>> print = list -> list.forEach(n -> System.out.print(n + " "));

        String line = sc.nextLine();

        while (!line.equals("end")) {
            switch (line) {
                case "add" ->  numbers = add.apply(numbers); // rewrite the new values to the original list
                case "subtract" -> numbers = subtract.apply(numbers);
                case "multiply" -> numbers = multiply.apply(numbers);
                case "print" -> {
                    print.accept(numbers);
                    System.out.println();

                }
            }
            line = sc.nextLine();
        }
    }
}
