package _06_DefiningClasses._06_PokemonTrainer;

import java.util.LinkedList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemons;


    Trainer(String name, int numberOfBadges, List<Pokemon> collectionOfPokemons) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemons = new LinkedList<>();
        this.collectionOfPokemons.addAll(collectionOfPokemons);

    }

    String getName() {
        return this.name;
    }

    int getNumberOfBadges() {
        return this.numberOfBadges;
    }




}
