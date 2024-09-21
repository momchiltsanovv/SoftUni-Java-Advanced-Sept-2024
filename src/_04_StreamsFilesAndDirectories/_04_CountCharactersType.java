package _04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _04_CountCharactersType {
    public static void main(String[] args) {

        String inputPath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output4.txt";

        int vowelCount = 0;
        int punctuationCount = 0;
        int otherSymbolCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = reader.readLine();
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vowelCount++;
                    } else if (c == '!' || c == '?' || c == '.' || c == ',') {
                        punctuationCount++;
                    }else {
                        if (c == ' '){
                            continue;
                        }
                        otherSymbolCount++;
                    }
                }
                line = reader.readLine();
            }
            writer.write("Vowels: " + vowelCount + "\n");
            writer.write("Other symbols: " + otherSymbolCount + "\n");
            writer.write("Punctuation: " + punctuationCount + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
