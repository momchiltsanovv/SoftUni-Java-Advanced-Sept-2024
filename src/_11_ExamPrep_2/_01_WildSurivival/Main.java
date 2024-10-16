package _11_ExamPrep_2._01_WildSurivival;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        Deque<Integer> beesQueue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(e -> beesQueue.offer(Integer.parseInt(e)));

        Deque<Integer> beeEatersStack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(e -> beeEatersStack.push(Integer.parseInt(e)));


        while (!beesQueue.isEmpty() && !beeEatersStack.isEmpty()) {


            int countBees = beesQueue.poll();
            int countBeeEaters = beeEatersStack.pop();

            while (countBeeEaters > 0 && countBees > 0) {
                if (countBees >= 7) {
                    countBeeEaters--;
                    countBees -= 7;
                } else { // count of bee eaters will always be positive because of the while
                    countBees = 0;
                }
            }
            if (countBeeEaters > 0) {
                beeEatersStack.push(countBeeEaters);
            } else if (countBees > 0) {
                beesQueue.offer(countBees);
            }
        }


        print(beesQueue, beeEatersStack);
    }
    private static void print(Deque<Integer> beesQueue, Deque<Integer> beeEatersStack) {

        StringBuilder sb = new StringBuilder();
        sb.append("The final battle is over!\n");

        if (beesQueue.isEmpty() && beeEatersStack.isEmpty()) {
            sb.append("But no one made it out alive!");
        } else {
            if (!beesQueue.isEmpty()) {
                sb.append("Bee groups left: ");
                beesQueue.forEach(pie -> sb.append(pie).append(", "));
            } else {
                sb.append("Bee-eater groups left: ");
                beeEatersStack.descendingIterator().forEachRemaining(pie -> sb.append(pie).append(", "));
            }
            sb.setLength(sb.length() - 2);
        }


        System.out.println(sb);
    }
}
