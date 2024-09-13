package _01_StackAndQueues;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import static java.lang.System.in;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        Stack<Integer> queue = new Stack<>();

        String[] input = sc.nextLine().split(" ");
        String[] numbers = sc.nextLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int toRemove = Integer.parseInt(input[1]);
        int searchFor = Integer.parseInt(input[2]);

        for (int i = 0; i < size; i++) {
            queue.add(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < toRemove; i++) {
            queue.pop();
        }

        if(queue.isEmpty()){
            System.out.println(0);
        } else if (queue.contains(searchFor)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }



    }
}
