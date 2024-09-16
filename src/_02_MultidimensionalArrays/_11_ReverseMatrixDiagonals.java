package _02_MultidimensionalArrays;

import java.util.*;

import static java.lang.System.in;

public class _11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int R = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, R, sc);

        int C = matrix.getFirst().size();
        List<List<Integer>> diagonals = new ArrayList<>();
        for (int i = 0; i < R + C - 1; i++) {
            diagonals.add(new ArrayList<>());
        }

        populateDiagonals(diagonals, R, matrix);
        printDiagonals(diagonals);

    }

    private static void fillMatrix(List<List<Integer>> matrix, int r, Scanner sc) {
        for (int i = 0; i < r; i++) {
            String[] line = sc.nextLine().split(" ");
            List<Integer> row = new ArrayList<>();
            for (String num : line) {
                row.add(Integer.parseInt(num));
            }
            matrix.add(row);
        }
    }

    private static void populateDiagonals(List<List<Integer>> diagonals, int r, List<List<Integer>> matrix) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                diagonals.get(i + j).add(matrix.get(i).get(j));
            }
        }
    }

    private static void printDiagonals(List<List<Integer>> diagonals) {
        for (int d = diagonals.size() - 1; d >= 0; d--) {
            List<Integer> diagonal = diagonals.get(d);
            for (int i = diagonal.size() - 1; i >= 0; i--) {
                System.out.print(diagonal.get(i) + " ");
            }
            System.out.println();
        }
    }
}
