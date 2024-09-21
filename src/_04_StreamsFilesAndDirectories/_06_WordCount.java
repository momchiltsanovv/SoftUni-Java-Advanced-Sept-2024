package _04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class _06_WordCount {
    public static void main(String[] args) throws IOException {


        String inputPath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String checkFilePath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
        String outputPath = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/result6.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(checkFilePath));

        String line = bufferedReader.readLine();
        String line2 = bufferedReader2.readLine();
        Map<String, Integer> wordCount = new HashMap<>();


        while (line != null) {
            String[] tokens = line.split("\\s+");

        }







    }
}
