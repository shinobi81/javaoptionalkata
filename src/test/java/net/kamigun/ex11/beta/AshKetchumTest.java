package net.kamigun.ex11.beta;

import net.kamigun.ex11.Bulbasaur;
import net.kamigun.ex11.Charmander;
import net.kamigun.ex11.Pokemon;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AshKetchumTest {
    private static final Charmander POKEMON_TO_FIND = new Charmander();
    private static final List<Pokemon> LIST_WITHOUT_CHARMANDER = List.of(new Bulbasaur());
    private static final List<Pokemon> LIST_WITH_CHARMANDER = List.of(new Charmander());

    private AshKetchum underTest;

    @Test
    void checkPokemonAshWithoutPokedexThrowsNoSuchElementException() {
        underTest = new AshKetchum();

        assertThrows(NoSuchElementException.class, () -> underTest.checkPokemon(POKEMON_TO_FIND));
    }

    @Test
    void checkPokemonAshWithPokedexWithoutPokemonsThrowsNoSuchElementException() {
        Pokedex pokedex = new Pokedex();
        underTest = new AshKetchum(pokedex);

        assertThrows(NoSuchElementException.class, () -> underTest.checkPokemon(POKEMON_TO_FIND));
    }

    @Test
    void checkPokemonAshWithPokedexWithWrongPokemonThrowsNoSuchElementException() {
        Pokedex pokedex = new Pokedex(LIST_WITHOUT_CHARMANDER);
        underTest = new AshKetchum(pokedex);

        assertThrows(NoSuchElementException.class, () -> underTest.checkPokemon(POKEMON_TO_FIND));
    }

    @Test
    void checkPokemonAshWithPokedexWithCorrectPokemonDontThrowsException() {
        Pokedex pokedex = new Pokedex(LIST_WITH_CHARMANDER);
        underTest = new AshKetchum(pokedex);

        assertDoesNotThrow(() -> underTest.checkPokemon(POKEMON_TO_FIND));
    }
}