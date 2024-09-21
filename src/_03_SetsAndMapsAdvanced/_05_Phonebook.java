package _03_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String[] tokens = sc.nextLine().split("-");

        Map<String, String> personInfo = new LinkedHashMap<>();

        while (!tokens[0].equals("search")) { // filling phonebook
            personInfo.put(tokens[0], tokens[1]);
            tokens = sc.nextLine().split("-");
        }

        String name = sc.nextLine(); //read names to search and checking if exist
        while(!name.equals("stop")) {
            if (personInfo.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, personInfo.get(name));
            } else {
                System.out.printf("Contact %s does not exist.\n", name);
            }
            name = sc.nextLine();
        }




    }
}
