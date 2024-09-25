package _05_FunctionalPrgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> result = new ArrayList<>();

        Function<List<Integer>, List<Integer>> reverseAndExclude = list -> {
            for (int i = list.size() - 1; i >= 0; i--) {
                if(list.get(i) % n != 0){
                    result.add(list.get(i));
                }
            }
            return result;
        };
        reverseAndExclude.apply(numbers).forEach(num -> System.out.printf("%d ", num));

    }
}

