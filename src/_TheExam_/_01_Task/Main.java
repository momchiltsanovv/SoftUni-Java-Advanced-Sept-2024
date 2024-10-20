package _TheExam_._01_Task;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        Deque<Integer> strengthStack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(e -> strengthStack.push(Integer.parseInt(e)));

        Deque<Integer> accuracyQueue = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(e -> accuracyQueue.offer(Integer.parseInt(e)));

        int scoredGoals = 0;
        while (!strengthStack.isEmpty() && !accuracyQueue.isEmpty()) {

            int curStrength = strengthStack.peek();
            int curAccuracy = accuracyQueue.peek();
            int sum = curAccuracy + curStrength;

            if (sum == 100) {
                strengthStack.pop();
                accuracyQueue.pop();
                scoredGoals++;
            }else if ( sum < 100) {
                if(curStrength < curAccuracy){
                    strengthStack.pop();
                }else if (curStrength > curAccuracy) {
                    accuracyQueue.pop();
                } else {
                    strengthStack.pop();
                    strengthStack.push(sum);
                    accuracyQueue.pop();
                }
            } else {
                curStrength -= 10;
                strengthStack.pop();
                strengthStack.push(curStrength);
                accuracyQueue.pop();
                accuracyQueue.offer(curAccuracy);
            }
        }

        if(scoredGoals == 3){
            System.out.println("Paul scored a hat-trick!");
        } else if( scoredGoals == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (scoredGoals > 3) {
            System.out.println("Paul performed remarkably well!");
        } else {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if(scoredGoals > 0) {
            System.out.printf("Goals scored: %d\n", scoredGoals);
        }

        if(!strengthStack.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("Strength values left: ");
            strengthStack.descendingIterator().forEachRemaining(e -> sb.append(e).append(", "));
            sb.setLength(sb.length() - 2);
            System.out.println(sb);
        }
        if(!accuracyQueue.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("Accuracy values left: ");
            accuracyQueue.forEach(e -> sb.append(e).append(", "));
            sb.setLength(sb.length() - 2);
            System.out.println(sb);
        }



    }
}
