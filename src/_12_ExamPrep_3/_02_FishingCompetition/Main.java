package _12_ExamPrep_3._02_FishingCompetition;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = readMatrix(size, sc);
        int[] position = getPosition(matrix);

        int caught = 0;
        boolean fellInWhirlpool = false;

        String command;
        while (!(command = sc.nextLine()).equals("collect the nets")) {
            matrix[position[0]][position[1]] = '-';

            move(command, position, size);
            char curPlace = matrix[position[0]][position[1]];

            if (curPlace == 'W') {
                fellInWhirlpool = true;
                caught = 0;
                break;
            } else if (Character.isDigit(curPlace)) {
                caught += Character.getNumericValue(curPlace);
                matrix[position[0]][position[1]] = '-';
            }
        }

        matrix[position[0]][position[1]] = 'S';
        print(fellInWhirlpool, position, caught, matrix);
    }

    private static void print(boolean fellInWhirlpool, int[] position, int caught, char[][] matrix) {
        if (fellInWhirlpool) {
            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                    "Last coordinates of the ship: [%d,%d]", position[0], position[1]);
        } else {
            if (caught < 20) {
                System.out.printf("You didn't catch enough fish and didn't reach the quota! " +
                        "You need %d tons of fish more.\n", 20 - caught);
            } else {
                System.out.println("Success! You managed to reach the quota!");
            }
            if(caught > 0) {
                System.out.printf("Amount of fish caught: %d tons.\n", caught);
            }
            printMatrix(matrix);
        }
    }

    private static void move(String command, int[] position, int size) {
        switch (command) {
            case "up" -> {
                position[0]--;
                if (isOutOfBounds(position, size)) {
                    position[0] = size - 1;
                }
            }
            case "down" -> {
                position[0]++;
                if (isOutOfBounds(position, size)) {
                    position[0] = 0;
                }
            }
            case "left" -> {
                position[1]--;
                if (isOutOfBounds(position, size)) {
                    position[1] = size - 1;
                }
            }
            case "right" -> {
                position[1]++;
                if (isOutOfBounds(position, size)) {
                    position[1] = 0;
                }
            }
        }
    }

    private static boolean isOutOfBounds(int[] position, int size) {
        return position[0] < 0 || position[0] >= size || position[1] < 0 || position[1] >= size;
    }

    private static int[] getPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cur : row) {
                System.out.print(cur);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int size, Scanner sc) {
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            char[] row = sc.nextLine().toCharArray();
            System.arraycopy(row, 0, matrix[i], 0, size);
        }
        return matrix;
    }
}
