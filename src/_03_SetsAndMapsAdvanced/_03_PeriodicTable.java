package _03_SetsAndMapsAdvanced;

import java.util.*;

import static java.lang.System.in;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        int size = sc.nextInt();
        sc.nextLine();

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            String[] input = sc.nextLine().split("\\s+");
            Collections.addAll(elements, input);
        }

        for(String cur : elements) {
            System.out.print(cur + " ");
        }






    }
}
