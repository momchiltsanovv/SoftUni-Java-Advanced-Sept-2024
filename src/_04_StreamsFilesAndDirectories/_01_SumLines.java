package _04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _01_SumLines {
    public static void main(String[] args) throws IOException {

        String input = "/Users/momchiltsanov/Developer/IntelliJ/SoftUni/Advanced/Exercises/SoftUni-Java-Advanced-Sept-2024/src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(input));

        String line = reader.readLine();

        while (line != null) {
            int sum = 0;
            for(char c : line.toCharArray()) {
                sum += c;
            }
            System.out.println(sum);
            line = reader.readLine();
        }



    }
}
