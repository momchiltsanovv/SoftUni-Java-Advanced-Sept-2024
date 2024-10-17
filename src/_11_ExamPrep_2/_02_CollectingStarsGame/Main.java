package _11_ExamPrep_2._02_CollectingStarsGame;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[n][n];
        readMatrix(matrix, sc);

        int[] playerPosition = getPosition(matrix);
        matrix[playerPosition[0]][playerPosition[1]] = '.';
        int starsCount = 2;

        while (starsCount < 10) {
            String direction = sc.nextLine();
            starsCount = getStarsCount(matrix, playerPosition, starsCount, direction);

            if (starsCount == 0) {
                break;
            }
            if (matrix[playerPosition[0]][playerPosition[1]] == '*') {
                starsCount++;
                matrix[playerPosition[0]][playerPosition[1]] = '.';
            }
        }

        matrix[playerPosition[0]][playerPosition[1]] = 'P'; // Setting last position to be P
        printText(playerPosition, starsCount);
        printMatrix(matrix);
    }

    private static void printText(int[] playerPosition, int starsCount) {
        if(starsCount == 0) {
            System.out.println("Game over! You are out of any stars.");
        }else {
            System.out.printf("You won! You have collected %d stars.\n", starsCount);
        }
        System.out.printf("Your final position is [%d, %d]\n", playerPosition[0], playerPosition[1]);
    }

    private static int getStarsCount(char[][] matrix, int[] playerPosition, int starsCount, String direction) {
        int[] newPosition = movePlayer(playerPosition, direction);

        if (isOutOfBounds(newPosition, matrix.length)) {
            playerPosition[0] = 0;
            playerPosition[1] = 0;
            return starsCount;
        }

        if (matrix[newPosition[0]][newPosition[1]] == '#') {
            starsCount--;
            return starsCount;
        }

        // Update player position if it's a valid move
        playerPosition[0] = newPosition[0];
        playerPosition[1] = newPosition[1];

        if (matrix[playerPosition[0]][playerPosition[1]] == '*') {
            starsCount++;
            matrix[playerPosition[0]][playerPosition[1]] = '.';
        }
        return starsCount;
    }

    private static int[] movePlayer(int[] playerPosition, String direction) {
        int[] newPosition = playerPosition.clone();

        switch (direction) {
            case "up" -> newPosition[0]--;
            case "down" -> newPosition[0]++;
            case "left" -> newPosition[1]--;
            case "right" -> newPosition[1]++;
        }
        return newPosition;
    }

    private static boolean isOutOfBounds(int[] position, int matrixSize) {
        return position[0] < 0 || position[0] >= matrixSize || position[1] < 0 || position[1] >= matrixSize;
    }

    private static int[] getPosition(char[][] matrix) {
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix.length; ++col) {
                if (matrix[row][col] == 'P') {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int col = 0; col < matrix.length; ++col) {
                System.out.print(chars[col] + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(char[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            String line = sc.nextLine().replaceAll("\\s+", "");
            for (int col = 0; col < matrix.length; ++col) {
                matrix[row][col] = line.charAt(col);
            }
        }
    }
}