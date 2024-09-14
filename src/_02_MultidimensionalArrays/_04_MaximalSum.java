package _02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class _04_MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[r][c];

        fillMatrix(matrix, sc);

        int maxSum = Integer.MIN_VALUE;
        //looking for a 3x3
        int startMaxRow = 0;
        int startMaxCol = 0;

        for (int rows = 0; rows < matrix.length - 2; rows++) {
            for (int cols = 0; cols < matrix[0].length - 2; cols++) {
                int  sum  = 0;
                for (int currnetRow = rows; currnetRow < rows + 3; ++currnetRow) {
                    for (int currnetCol = cols; currnetCol < cols + 3; ++currnetCol) {
                        sum += matrix[currnetRow][currnetCol];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    startMaxRow = rows;
                    startMaxCol = cols;
                }
            }

        }


        System.out.printf("Sum = %d\n", maxSum);
        printMaxSumMatrix(matrix, startMaxRow, startMaxCol);
    }

    private static void printMaxSumMatrix(int[][] matrix, int startMaxRow, int startMaxCol) {
        for (int rows = startMaxRow; rows < startMaxRow + 3; ++rows) {
            for (int cols = startMaxCol; cols < startMaxCol + 3; ++cols) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }


    private static void fillMatrix(int[][] matrix, Scanner sc) {
        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


    }
}
