package _01_StackAndQueues;

import java.util.*;

import static java.lang.System.in;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        List<String> brackets = Arrays.stream(sc.nextLine().split(""))
                .toList();

        String result = isBalanced(brackets) ? "YES" : "NO";

        System.out.println(result);
    }

    private static boolean isBalanced(List<String> brackets) {

        Deque<String> openBrackets = new ArrayDeque<>();

        for (String bracket : brackets) {

            switch (bracket) {

                case ")" -> {
                    if (openBrackets.isEmpty()) {
                        return false;
                    }
                    String openBracket = openBrackets.pop();
                    if (!openBracket.equals("(")) {
                        return false;
                    }
                }
                case "]" -> {
                    if (openBrackets.isEmpty()) {
                        return false;
                    }
                    String openBracket = openBrackets.pop();
                    if (!openBracket.equals("[")) {
                        return false;
                    }

                }
                case "}" -> {
                    if (openBrackets.isEmpty()) {
                        return false;
                    }
                    String openBracket = openBrackets.pop();
                    if (!openBracket.equals("{")) {
                        return false;
                    }
                }

                default -> openBrackets.push(bracket);
            }
        }

        return openBrackets.isEmpty();
    }
}
