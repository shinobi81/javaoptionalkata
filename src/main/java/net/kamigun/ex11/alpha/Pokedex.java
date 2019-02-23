package net.kamigun.ex11.alpha;

import net.kamigun.ex11.Bulbasaur;
import net.kamigun.ex11.Charmander;
import net.kamigun.ex11.Pokemon;
import net.kamigun.ex11.Squirtle;

import java.util.List;
import java.util.Optional;

public class Pokedex {

    public static final Charmander CHARMANDER = new Charmander();
    public static final Bulbasaur BULBASAUR = new Bulbasaur();
    public static final Squirtle SQUIRTLE = new Squirtle();
    public static final List<Pokemon> POKEMONS = List.of(CHARMANDER, BULBASAUR, SQUIRTLE);
    public static final String NOT_FOUND = "NOT FOUND";

    public String getPowerfulPokemon(int attackStat) {

        Optional<Pokemon> pokemon = POKEMONS.stream()
                .filter(p -> p.getAttackStat() > attackStat)
                .findFirst();

        if (pokemon.isPresent()) {
            return pokemon.get().getName();
        } else {
            return NOT_FOUND;
        }
    }
}
