package _04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _05_LineNumbers {
    public static void main(String[] args) {

        String inputPath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String outputPath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output5.txt";

        try (
                BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
                BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))
        ) {
            int lineNumber = 1;
            String line = reader.readLine();
            while (line != null) {
                writer.write(lineNumber+ ". " + line);
                writer.newLine();
                line = reader.readLine();
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
