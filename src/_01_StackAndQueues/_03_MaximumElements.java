package _01_StackAndQueues;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

public class _03_MaximumElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        Stack<Integer> stack = new Stack<>();

        int commands = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < commands; i++) {
            String[] input = sc.nextLine().split(" ");

            switch (Integer.parseInt(input[0])) {
                case 1 -> stack.push(Integer.parseInt(input[1]));
                case 2 -> stack.pop();
                case 3 -> System.out.println(Collections.max(stack));

            }

        }

    }
}