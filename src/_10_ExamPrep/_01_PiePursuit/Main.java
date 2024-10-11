package _10_ExamPrep._01_PiePursuit;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        ArrayDeque<Integer> contestantsCapacity = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(contestantsCapacity::offer);

        ArrayDeque<Integer> piesPieces = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(piesPieces::push);


        while (!contestantsCapacity.isEmpty() && !piesPieces.isEmpty()) {
            int currentPies = piesPieces.pop();
            int currentCapacity = contestantsCapacity.pop();
            if (currentPies == 0 || currentCapacity == 0) {
                continue;
            }

            if (currentCapacity >= currentPies) {
                currentCapacity -= currentPies;

                if (currentCapacity > 0) {
                    contestantsCapacity.offer(currentCapacity);
                }
            } else {
                currentPies -= currentCapacity;

                if (currentPies > 1) {
                    piesPieces.push(currentPies);
                } else if (currentPies == 1) {
                    if (!piesPieces.isEmpty() && currentPies == piesPieces.getLast()) {
                        continue;
                    }
                    if (!piesPieces.isEmpty()) {
                        piesPieces.push(currentPies + piesPieces.pop());
                    } else {
                        piesPieces.push(currentPies);
                    }
                }
            }
        }

        if (!contestantsCapacity.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.println("Contestants left: " + contestantsCapacity.peek());
        } else if (piesPieces.isEmpty()) {
            System.out.println("We have a champion!");
        } else {
            StringBuilder builder = new StringBuilder();
            piesPieces.descendingIterator().forEachRemaining(pie -> builder.append(pie).append(", "));
            if (!builder.isEmpty()) {
                builder.setLength(builder.length() - 2);
            }
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: " + builder);
        }


    }
}
