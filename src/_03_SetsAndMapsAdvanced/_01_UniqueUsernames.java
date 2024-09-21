package _03_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        int size = sc.nextInt();
        sc.nextLine();

        Set<String> setOfUsernames = new LinkedHashSet<>();


        for (int i = 0; i < size; i++) {
            String username = sc.nextLine();
            setOfUsernames.add(username);
        }

        for(String username : setOfUsernames) {
            System.out.println(username);
        }


    }
}
