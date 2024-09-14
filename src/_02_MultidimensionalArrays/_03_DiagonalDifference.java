package _02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        int n = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][n];

        fillMatrix(matrix, sc);
        int sumPrimary = sumPrimaryDiagonal(matrix);
        int sumSecondary = sumSecondaryDiagonal(matrix);
        System.out.println( Math.abs(sumPrimary - sumSecondary));
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            sum += matrix[rows][rows];
        }
        return sum;
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int cols = 0;
        for (int rows = matrix.length - 1; rows >= 0; rows--) {
            sum += matrix[rows][cols];
            cols++;
        }

        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner sc) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

    }


}
