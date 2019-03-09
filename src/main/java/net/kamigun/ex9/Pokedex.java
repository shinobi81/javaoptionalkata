package net.kamigun.ex9;

import lombok.AllArgsConstructor;

import java.io.PrintStream;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Consume an Optional if it Is Present.
 * If it Is Not Present, Then Execute an Empty-Based Action.
 *
 * This is a job for {@link Optional#ifPresentOrElse(Consumer, Runnable)}.
 *
 * @since Java 9
 */
@AllArgsConstructor
public class Pokedex {

    public static final String STATUS_NOT_FOUND = "Status not found";
    private final PrintStream printStream;

    public void showPokemonStatus(Pokemon pokemon) {
        Optional<String> status = pokemon.getStatus();

        if (status.isPresent()) {
            printStream.print(status.get());
        } else {
            printStream.print(STATUS_NOT_FOUND);
        }
    }
}
