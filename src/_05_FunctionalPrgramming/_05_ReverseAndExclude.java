package _05_FunctionalPrgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(numbers);

        int n = Integer.parseInt(sc.nextLine());

        Predicate<Integer> isNotDivisibleByN = number -> number % n != 0;

        Consumer<List<Integer>> print = list -> list.stream()
                .filter(isNotDivisibleByN)
                .toList()
                .forEach(sum -> System.out.print(sum + " "));

        print.accept(numbers);

    }
}

