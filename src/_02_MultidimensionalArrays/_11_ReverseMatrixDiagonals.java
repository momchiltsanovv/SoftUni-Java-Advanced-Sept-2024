package _02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class _11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];


        fillMatrix(matrix, sc);
        printAllDiagonals(matrix);


    }

    private static void fillMatrix(int[][] matrix, Scanner sc) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

    }

    private static void printAllDiagonals(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            /*
            23
            22  13
            21  12  03 WTF IS PATTERN HEREEEEEEEE
            20  11  02
            10  01
            00
            */

            for (int cols = 0 ; cols < matrix[row].length; cols++) {
                System.out.print(matrix[cols][row] + " ");
            }

            System.out.println();
        }


    }


}
