package net.kamigun.ex11.beta;

import lombok.Getter;
import net.kamigun.ex11.Pokemon;

import java.util.List;

@Getter
public class Pokedex {
    private List<Pokemon> pokemons;

    public Pokedex() {
        this.pokemons = List.of();
    }

    public Pokedex(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
