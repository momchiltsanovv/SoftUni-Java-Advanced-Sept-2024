package _02_MultidimensionalArrays;

import java.util.Scanner;

import static java.lang.System.in;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];


        String[] input = sc.nextLine().split(" ");

        while(!input[0].equals("Nuke")) {

            //TODO: finish logic



        }




        fillMatrix(matrix);
        printMatrix(matrix);




    }

    private static void fillMatrix(int[][] matrix) {
        int counter = 1;
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                matrix[row][col] = counter++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

