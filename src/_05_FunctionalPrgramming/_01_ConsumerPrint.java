package _05_FunctionalPrgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import static java.lang.System.in;

public class _01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        List<String> names = Arrays.asList(sc.nextLine().split("\\s+"));

        Consumer<List<String>> print = list -> names.forEach(System.out::println);

        print.accept(names);
    }

}
