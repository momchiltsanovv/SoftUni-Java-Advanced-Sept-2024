package _02_MultidimensionalArrays;

import java.util.Scanner;

import static java.lang.System.in;

public class _01_fillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String[] input = sc.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);

        int[][] result;
        if(type == 'A')
            result = typeA(n);
        else
            result = typeB(n);

        printMatrix(result);

    }


    public static int[][] typeA(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];

        int counter  = 1;
        for (int rows = 0; rows < dimensions; rows++) {
            for (int cols = 0; cols < dimensions; cols++) {
                matrix[cols][rows] = counter++;
            }
        }
        return matrix;
    }

    public static int[][] typeB(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];

        int counter  = 1;
        for (int rows = 0; rows < dimensions; rows++) {
            if(rows % 2 == 0) {
                for (int cols = 0; cols < dimensions; cols++) {
                    matrix[cols][rows] = counter++;
                }
            } else {
                for (int cols = matrix.length - 1; cols >= 0; cols--) {
                    matrix[cols][rows] = counter++;
                }
            }

        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}
