package net.kamigun.ex10;

import java.util.Optional;

public class Pokedex {

    public static final Optional<String> DEFAULT_STATUS = Optional.of("PENDING");

    public Optional<String> showPokemonStatus(Pokemon pokemon) {
        Optional<String> status = pokemon.getStatus();

        if (status.isPresent()) {
            return status;
        } else {
            return DEFAULT_STATUS;
        }
    }
}
