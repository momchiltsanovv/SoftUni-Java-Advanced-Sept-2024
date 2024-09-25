package _05_FunctionalPrgramming;

import static java.lang.System.in;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;


public class _02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        Consumer<String> printNames = name -> System.out.printf("Sir %s\n", name);

        Arrays.stream(sc.nextLine().split("\\s+")).forEach(printNames);


    }
}
