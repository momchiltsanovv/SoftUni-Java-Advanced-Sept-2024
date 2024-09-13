package _01_StackAndQueues;

import java.util.Scanner;

import static java.lang.System.in;

public class _06_RecursiveFibonacci {
    private static long[] memory;

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int number = Integer.parseInt(sc.nextLine());
        memory = new long[number + 1];

        System.out.println(fib(number));
    }

    public static long fib(int n) {
        if (n < 2)
            return 1;

        if (memory[n] != 0) {
            return memory[n];
        } else {
            memory[n] = fib(n - 1) + fib(n - 2);
        }
        return memory[n];
    }
}