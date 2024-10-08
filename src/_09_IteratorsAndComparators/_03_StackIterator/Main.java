package _09_IteratorsAndComparators._03_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String[] tokens = sc.nextLine().replaceAll(",", "").split("\\s+");
        String[] elements = Arrays.copyOfRange(tokens, 1, tokens.length);
        StackIter stack = new StackIter(elements);

        tokens = sc.nextLine().replaceAll(",", "").split("\\s+");
        while (!tokens[0].equals("END")) {
            switch (tokens[0]) {
                case "Push" -> stack.push(tokens[1]);
                case "Pop" -> stack.pop();
            }

            tokens = sc.nextLine().replaceAll(",", "").split("\\s+");
        }
        stack.forEachTwice();


    }
}
