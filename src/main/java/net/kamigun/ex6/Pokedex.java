package net.kamigun.ex6;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * When No Value Is Present, Throw an Explicit Exception via {@link Optional#orElseThrow(Supplier)}.
 */
public class Pokedex {

    public String showPokemonStatus(Pokemon pokemon) {
        Optional<String> status = pokemon.getStatus();

        if (status.isPresent()) {
            return status.get();
        } else {
            throw new IllegalStateException();
        }
    }
}
