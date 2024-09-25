package _05_FunctionalPrgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.in;

public class _04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).toList();


        //Function<List<Integer>, Integer> sum = list ->


    }
}
