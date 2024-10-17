package _12_ExamPrep_3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class _01_OffroadChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        Deque<Integer> initialFuelStack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(e -> initialFuelStack.push(Integer.parseInt(e)));

        Deque<Integer> consumptionIndexQueue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(e -> consumptionIndexQueue.offer(Integer.parseInt(e)));

        Deque<Integer> necessaryAmountQueue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(e -> necessaryAmountQueue.offer(Integer.parseInt(e)));

        List<Integer> reachedAltitudes = new ArrayList<>();

        int altitude = 0;
        boolean reachedAll = true;
        while (!initialFuelStack.isEmpty() && !consumptionIndexQueue.isEmpty() && !necessaryAmountQueue.isEmpty()) {
            int initFuel = initialFuelStack.peek();
            int consumptionIndex = consumptionIndexQueue.peek();
            int necessaryAmount = necessaryAmountQueue.peek();

            int result = initFuel - consumptionIndex;
            if (result < necessaryAmount) {
                System.out.printf("John did not reach: Altitude %d\n", altitude + 1); // plus 1 so we mark the one where he is headed without incrementing the initial altitude
                reachedAll = false;
                break;
            }
            altitude++;
            reachedAltitudes.add(altitude);
            System.out.printf("John has reached: Altitude %d\n", altitude);

            //remove only if result >= necessaryAmount
            initialFuelStack.pop();
            consumptionIndexQueue.poll();
            necessaryAmountQueue.poll();
        }

        print(altitude, initialFuelStack, reachedAltitudes, reachedAll);
    }

    private static void print(int altitude, Deque<Integer> initialFuelStack, List<Integer> reachedAltitudes, boolean reachedAll) {
        StringBuilder sb = new StringBuilder();

        if (altitude > 0 && !initialFuelStack.isEmpty()) {
            sb.append("John failed to reach the top.\n");
            sb.append("Reached altitudes: ");
            reachedAltitudes.forEach(e -> sb.append("Altitude ").append(e).append(", "));
            sb.setLength(sb.length() - 2);
        } else if (altitude == 0) {
            sb.append("John failed to reach the top.\nJohn didn't reach any altitude.");
        } else if (reachedAll) {
            sb.append("John has reached all the altitudes and managed to reach the top!");
        }
        System.out.println(sb);
    }
}
