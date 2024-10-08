package _09_IteratorsAndComparators._01_ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String[] command = sc.nextLine().split("\\s+");

        String[] elements= Arrays.copyOfRange(command, 1, command.length);
        ListyIterator list = new ListyIterator(elements);

        while(!command[0].equals("END")) {
            switch (command[0]) {
                case "Print"  -> list.print();
                case "Move" -> System.out.println(list.move());
                case "HasNext" -> System.out.println(list.hasNext());
            }
            command = sc.nextLine().split("\\s+");
        }
    }
}
