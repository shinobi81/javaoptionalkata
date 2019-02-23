package net.kamigun.ex9;

import lombok.AllArgsConstructor;

import java.io.PrintStream;
import java.util.Optional;

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
