package net.kamigun.ex10;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * When the Value Is Present, Set/Return That Optional.
 * When No Value Is Present, Set/Return the Other Optional.
 *
 * This is a job for {@link Optional#or(Supplier)}.
 *
 * @since Java 9
 */
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
