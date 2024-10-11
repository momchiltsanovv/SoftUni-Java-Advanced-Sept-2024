package _09_IteratorsAndComparators._04_Froggy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        String command = sc.nextLine();

        Lake lake = new Lake(input);

        StringBuilder result = new StringBuilder();
        lake.forEach(num -> result.append(num).append(", "));
        if (!result.isEmpty()) {
            result.setLength(result.length() - 2); // Remove the last ", "
        }
        System.out.println(result);



    }
}
