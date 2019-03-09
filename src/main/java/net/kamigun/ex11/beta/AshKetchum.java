package net.kamigun.ex11.beta;

import net.kamigun.ex11.Pokemon;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * {@link Optional#orElse(Object)}/{@link Optional}{@code .orElseXXX} are a Perfect Replacement for {@code isPresent()-get()} pair in lambdas.
 */
public class AshKetchum {

    private Optional<Pokedex> pokedex;

    public AshKetchum() {
        this.pokedex = Optional.empty();
    }

    public AshKetchum(Pokedex pokedex) {
        this.pokedex = Optional.of(pokedex);
    }

    public void checkPokemon(Pokemon pokemon) {
        if (!pokedex.isPresent()
                || !pokedex.get().getPokemons().contains(pokemon)) {
            throw new NoSuchElementException();
        }
    }
}
