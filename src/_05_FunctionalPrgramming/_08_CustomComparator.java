package _05_FunctionalPrgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.in;

public class _08_CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Predicate<Integer> isPrime = number -> number % 2 == 0;

         List<Integer> odds = new ArrayList<>(numbers.stream().filter(isPrime).toList());
         List<Integer> evens = new ArrayList<>(numbers.stream().filter(isPrime.negate()).toList());
        Collections.sort(odds);
        Collections.sort(evens);
        odds.forEach(n -> System.out.print(n + " "));
        evens.forEach(n -> System.out.print(n + " "));




    }
}
