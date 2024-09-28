package _05_FunctionalPrgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.in;

public class _09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> divisors = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Predicate<Integer> isDivisibleByAll = num -> divisors.stream().allMatch(divisor -> num % divisor == 0);

        List<Integer> result = IntStream.rangeClosed(1, n)
                .filter(isDivisibleByAll::test)
                .boxed() // Box the ints to Integers
                .toList();

        System.out.println(result.stream()
                .map(String::valueOf) // Convert integers to strings
                .collect(Collectors.joining(" ")));




    }
}
