package _02_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class _06_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        Map<String, String> info = new LinkedHashMap<>();
        String name = sc.nextLine();
        while (!name.equals("stop")) {
            String email = sc.nextLine();

            if (email.charAt(email.length() - 1) == 's' ||
                    email.charAt(email.length() - 1) == 'k' ||
                    email.charAt(email.length() - 1) == 'm') {
                name = sc.nextLine();
                continue;
            }
            info.put(name, email);
            name = sc.nextLine();
        }

        for (Map.Entry<String, String> entry : info.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }


    }
}
