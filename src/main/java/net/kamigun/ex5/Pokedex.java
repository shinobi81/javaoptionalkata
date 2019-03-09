package net.kamigun.ex5;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * When No Value Is Present, throw a {@link NoSuchElementException} via {@link Optional#orElseThrow()}
 * @since Java 10
 */
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
