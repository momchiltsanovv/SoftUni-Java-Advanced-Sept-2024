package _03_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int sizeFirstSet = sc.nextInt();
        int sizeSecondSet = sc.nextInt();
        Set<Integer> firstSetNumbers = new LinkedHashSet<>();
        Set<Integer> secondSetNumbers = new LinkedHashSet<>();


        for (int i = 0; i < sizeFirstSet ; i++) {
            firstSetNumbers.add(sc.nextInt());
        }

        for (int i = 0; i < sizeSecondSet; i++) {
            secondSetNumbers.add(sc.nextInt());
        }

        firstSetNumbers.retainAll(secondSetNumbers);

        for(int num : firstSetNumbers){
            System.out.print(num + " ");
        }
        sc.close();









    }
}
