package _05_FunctionalPrgramming;

import static java.lang.System.in;

import java.util.*;
import java.util.function.Function;


public class _07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Function<List<Integer>, Integer> minNum = list -> {
            int min = Integer.MAX_VALUE;
            int minIndex = -1; // Initialize to an invalid index

            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i);
                if (number <= min) {
                    min = number;
                    minIndex = i;
                }
            }
            return minIndex;
        };

        System.out.println(minNum.apply(numbers));



        //Another solution:
        //        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();

        //        int rightmostIndex = IntStream.range(0, numbers.size())
        //                .filter(i -> numbers.get(i).equals(min.getAsInt()))
        //                .reduce((first, second) -> second)
        //                .orElse(-1);

    }

}
