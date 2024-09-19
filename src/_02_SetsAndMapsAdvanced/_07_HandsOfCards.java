package _02_SetsAndMapsAdvanced;

import java.util.*;

import static java.lang.System.in;

public class _07_HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String[] input = sc.nextLine().split(":");
        String name = input[0];
        List<String> cards = List.of(input[1].split(", "));
        Map<String, List<String>> info = new LinkedHashMap<>();

        while(!name.equals("JOKER")){
            info.put(name, new ArrayList<>());
            info.get(name).addAll(cards);



        }


    }
}
