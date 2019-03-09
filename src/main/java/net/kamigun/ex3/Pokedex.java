package net.kamigun.ex3;

import java.util.Optional;

/**
 * When No Value Is Present, Set/Return an Already-Constructed Default Object via {@link Optional#orElse(Object)}.
 */
public class Pokedex {
    public static final String UNKNOWN_POKEMON_STATUS = "UNKNOWN";

    public String showPokemonStatus(Pokemon pokemon) {
        Optional<String> status = pokemon.getStatus();

        if (status.isPresent()) {
            return status.get();
        } else {
            return UNKNOWN_POKEMON_STATUS;
        }
    }
}
