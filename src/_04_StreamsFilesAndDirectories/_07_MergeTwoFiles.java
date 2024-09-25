package _04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.System.in;

public class _07_MergeTwoFiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String inputPath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String input2Path = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String mergeFilePath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/mergeResult7.txt";

        try (
                BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
                BufferedReader reader2 = Files.newBufferedReader(Path.of(input2Path));
                BufferedWriter writer = Files.newBufferedWriter(Path.of(mergeFilePath))
        ) {
            String line = reader.readLine();
            String line2 = reader2.readLine();
            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
            }

            while (line2 != null) {
                writer.write(line2);
                writer.newLine();
                line2 = reader2.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
