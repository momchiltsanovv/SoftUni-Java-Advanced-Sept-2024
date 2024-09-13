package _01_StackAndQueues;

import java.util.Scanner;
import java.util.ArrayDeque;
import static java.lang.System.in;

public class _01_ReverseNUmbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String[] input = sc.nextLine().split(" ");

        for (String s : input) {
            numbers.push(Integer.parseInt(s));
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(numbers.pop() + " ");
        }

    }
}
