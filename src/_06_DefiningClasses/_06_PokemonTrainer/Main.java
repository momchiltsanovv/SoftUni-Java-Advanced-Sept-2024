package _06_DefiningClasses._06_PokemonTrainer;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        Set<Trainer> trainers = new LinkedHashSet<>();

        String[] tokens = sc.nextLine().split("\\s+");
        while (!tokens[0].equals("Tournament")) {

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            //Trainer trainer = new Trainer(trainerName,0, asd);
            //trainers.add(trainer);

            tokens = sc.nextLine().split("\\s+");
        }

        for (Trainer trainer : trainers) {
            System.out.println(trainer.getName());
            System.out.println(trainer.getNumberOfBadges());
        }


    }
}
