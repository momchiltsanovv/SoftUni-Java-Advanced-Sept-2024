package _02_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int rotation = Integer.parseInt(sc.nextLine().split("\\(")[1].replaceAll("\\)", ""));

        int rotationAngle = rotation % 360;


        String input = sc.nextLine();

        List<String> lines = new ArrayList<>();
        int maxColSize = Integer.MIN_VALUE;
        while(!input.equals("END")){
            lines.add(input);

            if(input.length() > maxColSize){
                maxColSize = input.length();
            }

            input = sc.nextLine();

        }

        int rows = lines.size();
        int cols = maxColSize;
        char[][] matrix = new char[rows][cols];


        fillMatrix(matrix, lines);

        switch (rotationAngle) {
            case 90 -> matrix = rotate90(matrix, rows, cols); 
            case 180 -> {
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix, cols, rows);
            }
            case 270 -> {
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix, cols, rows);
                matrix = rotate90(matrix, rows, cols);
            }

        }

        printMatrix(matrix);


    }

    private static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; ++rows) {
            for (int cols = 0; cols < matrix[rows].length; ++cols) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static char[][] rotate90(char[][] matrix, int rows, int cols) {
        
        char[][] rotatedMatrix = new char[cols][rows];
        for (int col = 0; col < cols; ++col) {
            int columnCounter = 0;
            for (int row = rows - 1; row >= 0; --row) {
                rotatedMatrix[col][columnCounter++] = matrix[row][col];
            }
        }


        return rotatedMatrix;
    }

    private static void fillMatrix(char[][] matrix, List<String> lines) {
        for (int row = 0; row < matrix.length; ++row) {
            String currentLine = lines.get(row);
            for (int col = 0; col < matrix[row].length; ++col) {
                if(col < currentLine.length()){
                    matrix[row][col] = currentLine.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }
}
