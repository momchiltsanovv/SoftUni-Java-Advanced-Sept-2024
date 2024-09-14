package _02_MultidimensionalArrays;

import java.util.Scanner;

import static java.lang.System.in;

public class _02_MatrixOfPlaindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix);
        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char outsideSymbol = (char) ('a' + row);
                char insideSymbol = (char) ('a' + row + col);
                matrix[row][col] = String.valueOf(outsideSymbol) +  insideSymbol + outsideSymbol;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
