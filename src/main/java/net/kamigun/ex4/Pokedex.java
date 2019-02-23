package net.kamigun.ex4;

import java.util.Optional;

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
