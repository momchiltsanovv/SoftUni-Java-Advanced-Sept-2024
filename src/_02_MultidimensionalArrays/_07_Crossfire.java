package _02_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] tokens = input.split(" ");
            int targetRow = Integer.parseInt(tokens[0]);
            int targetCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            destroyVertically(matrix, targetRow, targetCol, radius);
            destroyHorizontally(matrix, targetRow, targetCol, radius);

            removeNulls(matrix);

            input = scanner.nextLine();
        }

        print(matrix);
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(number++);
            }
            matrix.add(row);
        }
    }

    private static void destroyVertically(List<List<Integer>> matrix, int targetRow, int targetCol, int radius) {
        for (int r = targetRow - radius; r <= targetRow + radius; r++) {
            if (r >= 0 && r < matrix.size() && targetCol >= 0 && targetCol < matrix.get(r).size()) {
                matrix.get(r).set(targetCol, null);
            }
        }
    }

    private static void destroyHorizontally(List<List<Integer>> matrix, int targetRow, int targetCol, int radius) {
        if (targetRow >= 0 && targetRow < matrix.size()) {
            List<Integer> targetRowList = matrix.get(targetRow);
            for (int c = targetCol - radius; c <= targetCol + radius; c++) {
                if (c >= 0 && c < targetRowList.size()) {
                    targetRowList.set(c, null);
                }
            }
        }
    }

    private static void removeNulls(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            integers.removeIf(Objects::isNull);
        }
        matrix.removeIf(List::isEmpty);
    }

    private static void print(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int i = 0; i < row.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(row.get(i));
            }
            System.out.println();
        }

    }
}