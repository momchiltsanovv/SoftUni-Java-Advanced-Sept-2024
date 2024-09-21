package _04_StreamsFilesAndDirectories;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _02_SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "src/_04_StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        long sum = 0;
        while (line != null) {
            for(char c : line.toCharArray()) {
                sum += Integer.hashCode(c);
            }
            line = reader.readLine();
        }
        System.out.println(sum);




    }
}
