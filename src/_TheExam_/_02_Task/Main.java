package _TheExam_._02_Task;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String[] dimensions = sc.nextLine().split(", ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        char[][] matrix = readMatrix(n, m, sc);
        int[] position = getPosition(matrix);

        boolean bombDefused = false;
        boolean bombExploded = false;
        int time = 16;
        String command = sc.nextLine();

        while (true) {
            switch (command) {
                case "up" -> { // 
                    position[0]--;
                    if (position[0] < 0) {
                        position[0]++;
                    }
                }
                case "down" -> {
                    position[0]++;
                    if (position[0] >= matrix.length) { 
                        position[0]--;
                    }
                }
                case "left" -> {
                    position[1]--;
                    if (position[1] < 0) {
                        position[1]++;
                    }
                }
                case "right" -> {
                    position[1]++;
                    if (position[1] >= m) {
                        position[1]--;
                    }
                }
                case "defuse" -> {
                    if (matrix[position[0]][position[1]] == 'B') {
                        if (time - 4 >= 0) {
                            bombDefused = true;
                            matrix[position[0]][position[1]] = 'D';
                        } else {
                            bombExploded = true;
                            matrix[position[0]][position[1]] = 'X';
                        }
                        time -= 4;  // Deduct 4 seconds for defusing
                    } else {
                        time -= 2;  // Deduct 2 seconds if the bomb is not here
                    }
                }
            }

            if (!command.equals("defuse")) {
                time--;  // Deduct 1 second
            }

            if (bombDefused || bombExploded || time <= 0) {
                break;
            }

            if (matrix[position[0]][position[1]] == 'T') {
                matrix[position[0]][position[1]] = '*';
                break;
            }
            command = sc.nextLine();
        }

        print(bombDefused, time, bombExploded);
        printMatrix(matrix);
    }

    private static void print(boolean bombDefused, int time, boolean bombExploded) {
        if (bombDefused) {
            System.out.println("Counter-terrorist wins!");
            System.out.printf("Bomb has been defused: %d second/s remaining.%n", time);
        } else if (bombExploded || time <= 0) {
            System.out.println("Terrorists win!");
            int neededTime = Math.abs(time);  // abs because the time would be less than 1 which is how much we need to defuse
            System.out.println("Bomb was not defused successfully!");
            System.out.printf("Time needed: %d second/s.%n", neededTime);
        } else { // killed by terrorists
            System.out.println("Terrorists win!");
        }
    }

    private static int[] getPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'C') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int n, int m, Scanner sc) {
        char[][] matrix = new char[n][m];
        for (int row = 0; row < n; row++) {
            String line = sc.nextLine();
            for (int col = 0; col < m; col++) {
                matrix[row][col] = line.charAt(col);
            }
        }
        return matrix;
    }


}

