import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        ArrayList[][] matrix = new ArrayList[5][5];
        fillMatrix(matrix);

        String[] input = sc.nextLine().split(" ");

        while(!input[0].equals("Nuke")) {

            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            int radius = Integer.parseInt(input[2]);
            
            matrix = bombUp(matrix, row, col, radius);


            input = sc.nextLine().split(" ");
        }



        print(matrix);

    }

    private static void fillMatrix(ArrayList[][] matrix) {
        int counter = 1;
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                matrix[row][col] = new ArrayList<>();
                matrix[row][col].add(counter++);

            }
        }
    }

    private static ArrayList[][] bombUp(ArrayList[][] matrix, int row, int col, int radius) {
        for (int i = row;  radius >= 0 ; i--) {
            for (int j = col; j < matrix.length; ++j) {
                    matrix[i][j].clear();
                    radius--;
                    break;
            }

        }


        return matrix;
    }

    private static void print(ArrayList[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }
}