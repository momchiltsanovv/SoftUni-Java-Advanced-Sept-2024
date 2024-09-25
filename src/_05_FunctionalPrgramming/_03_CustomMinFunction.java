package _05_FunctionalPrgramming;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.in;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> minNum = list -> {
            int min = Integer.MAX_VALUE;
            for (int number : numbers) {
                if (number < min) {
                    min = number;
                }
            }
            return min;
        };
        System.out.println(minNum.apply(numbers));


    }

}
