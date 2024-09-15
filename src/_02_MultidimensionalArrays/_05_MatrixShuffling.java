package _02_MultidimensionalArrays;

import java.util.Scanner;

import static java.lang.System.in;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, sc);

        String[] input = sc.nextLine().split("\\s+");
        while (!input[0].equals("END")) {
            boolean isValid = true;
            if (input[0].equals("swap") && input.length == 5) {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);

                if (row1 >= 0 && row1 < matrix.length && row2 >= 0 && row2 < matrix.length &&
                        col1 >= 0 && col1 < matrix[row1].length && col2 >= 0 && col2 < matrix[row2].length) {
                    String tmp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = tmp;
                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
            if (!isValid) {
                System.out.println("Invalid input!");
                input = sc.nextLine().split("\\s+");
                continue;
            }

            printMatrix(matrix);
            input = sc.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner sc) {
        for (int rows = 0; rows < matrix.length; ++rows) {
            matrix[rows] = sc.nextLine().split("\\s+");
        }


    }
}
