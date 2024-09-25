package _05_FunctionalPrgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.lang.System.in;


public class _06_PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = Integer.parseInt(sc.nextLine());

        List<String> names = Arrays.asList(sc.nextLine().split("\\s+"));
        Predicate<String> isRightLength = name -> name.length() <= n;
        List<String> filteredNames = names.stream()
                .filter(isRightLength).toList();

        Consumer<List<String>> printName = list -> list.forEach(System.out::println);
        printName.accept(filteredNames);



    }
}
