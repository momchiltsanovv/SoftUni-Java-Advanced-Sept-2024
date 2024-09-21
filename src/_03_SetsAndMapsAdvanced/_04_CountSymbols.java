package _03_SetsAndMapsAdvanced;

import java.util.*;

import static java.lang.System.in;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        char[] input = sc.nextLine().toCharArray();
        Map<Character,Integer> symbols = new TreeMap<>();

        for (char c : input) {
            symbols.putIfAbsent(c, 0);
            symbols.put(c, symbols.get(c) + 1);
        }
         for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
             System.out.printf("%c: %d time/s\n", entry.getKey(), entry.getValue());
         }
    }
}
