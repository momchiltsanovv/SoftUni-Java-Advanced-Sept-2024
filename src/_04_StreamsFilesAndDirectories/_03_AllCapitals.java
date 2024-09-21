package _04_StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class _03_AllCapitals {
    public static void main(String[] args) throws IOException {

        String pathInput = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String pathOutput = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output3.txt";

        try (
                BufferedReader reader = Files.newBufferedReader(Path.of(pathInput));
                BufferedWriter writer = Files.newBufferedWriter(Path.of(pathOutput))
        ) {
            String line = reader.readLine();
            while (line != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
