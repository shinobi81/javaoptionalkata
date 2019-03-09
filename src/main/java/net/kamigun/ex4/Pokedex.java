package net.kamigun.ex4;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * When No Value Is Present, Set/Return a Non-Existent Default Object via {@link Optional#orElseGet(Supplier)}.
 */
public class Pokedex {

    String elaborateStatus() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "ELABORATED STATUS";
    }

    public String showPokemonStatus(Pokemon pokemon) {
        Optional<String> status = pokemon.getStatus();

        if (status.isPresent()) {
            return status.get();
        } else {
            return elaborateStatus();
        }
    }
}
