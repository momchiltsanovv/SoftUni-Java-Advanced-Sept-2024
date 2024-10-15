package _10_ExamPrep_1._02_EscapeTheMaze;

import java.util.Scanner;

import static java.lang.System.in;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        int n = Integer.parseInt(sc.nextLine());

        char[][] maze = new char[n][n];

        readMatrix(maze, sc);
        int[] position = getStartingPosition(maze);
        int health = 100;
        boolean isDead = false;

        while (true) {
            String direction = sc.nextLine();
            maze[position[0]][position[1]] = '-';
            if (move(direction, position, maze)) continue;

            if (maze[position[0]][position[1]] == 'X') {
                maze[position[0]][position[1]] = 'P';
                break;
            } else if (maze[position[0]][position[1]] == 'H') {
                health += 15;
                if (health > 100) {
                    health = 100;
                }
                maze[position[0]][position[1]] = '-';
            }
            if (maze[position[0]][position[1]] == 'M') {
                health -= 40;
                if (health <= 0) {
                    maze[position[0]][position[1]] = 'P';
                    health = 0;
                    isDead = true;
                    break;
                } else {
                    maze[position[0]][position[1]] = '-';
                }
            }
        }

        print(isDead, health, maze);
    }

    private static void print(boolean isDead, int health, char[][] maze) {
        if (isDead) {
            System.out.println("Player is dead. Maze over!");
        } else {
            System.out.println("Player escaped the maze. Danger passed!");
        }
        System.out.printf("Player's health: %d units\n", health);
        printMatrix(maze);
    }

    private static boolean move(String direction, int[] position, char[][] maze) {
        switch (direction) {
            case "up" -> {
                position[0]--;
                if (position[0] >= maze.length) {
                    position[0]++; //returning to original if out of bounds
                    return true;
                }
            }
            case "down" -> {
                position[0]++;
                if (position[0] >= maze.length) {
                    position[0]--;
                    return true;
                }
            }
            case "left" -> {
                position[1]--;
                if (position[1] >= maze.length) {
                    position[1]++;
                    return true;
                }
            }
            case "right" -> {
                position[1]++;
                if (position[1] >= maze.length) {
                    position[1]--;
                    return true;
                }
            }
        }
        return false;
    }

    private static void printMatrix(char[][] maze) {
        for (char[] chars : maze) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static int[] getStartingPosition(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'P') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static void readMatrix(char[][] maze, Scanner sc) {
        for (int row = 0; row < maze.length; row++) {
            String line = sc.nextLine();
            for (int col = 0; col < maze[row].length; col++) {
                maze[row][col] = line.charAt(col);
            }
        }
    }

}
