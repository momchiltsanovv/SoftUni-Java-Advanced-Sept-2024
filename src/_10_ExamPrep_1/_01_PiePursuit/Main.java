package _10_ExamPrep_1._01_PiePursuit;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        ArrayDeque<Integer> contestantsQueue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(contestantsQueue::offer);

        ArrayDeque<Integer> piesStack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(piesStack::push);


        while (!contestantsQueue.isEmpty() && !piesStack.isEmpty()) {
            int currentPies = piesStack.pop();
            int currentCapacity = contestantsQueue.pop();
            if (currentPies == 0 || currentCapacity == 0) {
                continue;
            }

            if (currentCapacity >= currentPies) {
                currentCapacity -= currentPies;

                if (currentCapacity > 0) {
                    contestantsQueue.offer(currentCapacity);
                }
            } else {
                currentPies -= currentCapacity;

                if (currentPies > 1) {
                    piesStack.push(currentPies);
                } else if (currentPies == 1) {
                    if (!piesStack.isEmpty() && currentPies == piesStack.getLast()) {
                        continue;
                    }
                    if (!piesStack.isEmpty()) {
                        piesStack.push(currentPies + piesStack.pop());
                    } else {
                        piesStack.push(currentPies);
                    }
                }
            }
        }

        if (!contestantsQueue.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.println("Contestants left: " + contestantsQueue.peek());
        } else if (piesStack.isEmpty()) {
            System.out.println("We have a champion!");
        } else {

            StringBuilder builder = new StringBuilder();
            piesStack.descendingIterator().forEachRemaining(pie -> builder.append(pie).append(", "));
            if (!builder.isEmpty()) {
                builder.setLength(builder.length() - 2);
            }
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: " + builder);
        }


    }
}
