package net.kamigun.ex8;

import lombok.AllArgsConstructor;

import java.io.PrintStream;
import java.util.Optional;

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
