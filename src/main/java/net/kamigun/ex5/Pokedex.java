package net.kamigun.ex5;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Pokedex {

    public String showPokemonStatus(Pokemon pokemon) {
        Optional<String> status = pokemon.getStatus();

        if (status.isPresent()) {
            return status.get();
        } else {
            throw new NoSuchElementException();
        }
    }
}
