package net.kamigun.ex8;

import lombok.AllArgsConstructor;

import java.io.PrintStream;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Consume an Optional if it Is Present.
 * Do Nothing if it Is Not Present.
 *
 * This is a job for {@link Optional#ifPresent(Consumer)}.
 */
@AllArgsConstructor
public class Pokedex {

    private final PrintStream printStream;

    public void showPokemonStatus(Pokemon pokemon) {
        Optional<String> status = pokemon.getStatus();

        if (status.isPresent()) {
            printStream.print(status.get());
        }
    }
}
