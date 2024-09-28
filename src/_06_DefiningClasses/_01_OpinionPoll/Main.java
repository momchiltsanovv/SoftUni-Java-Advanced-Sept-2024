package _06_DefiningClasses._01_OpinionPoll;

import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = Integer.parseInt(sc.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);

            people.add(person);
        }

        people.sort(Comparator.comparing(Person::getName)); // sorting by name

        people.stream().filter(person -> person.getAge() > 30)
                .forEach(person -> System.out.printf("%s - %d\n", person.getName(), person.getAge())); // printing via stream





    }
}
