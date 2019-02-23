package net.kamigun.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokedexTest {
    public static final String SLEEP_STATUS = "SLEEP";
    private Pokedex underTest;

    @BeforeEach
    void setUp() {
        underTest = new Pokedex();
    }

    @Test
    void showPokemonStatusOfSleepyPokemonReturnSleepStatus() {
        Pokemon pokemon = new Pokemon(SLEEP_STATUS);

        String result = underTest.showPokemonStatus(pokemon);

        Assertions.assertEquals(SLEEP_STATUS, result);
    }

    @Test
    void showPokemonStatusOfUnknownPokemonThrowsNoSuchElementException() {
        Pokemon pokemon = new Pokemon();

        Assertions.assertThrows(
                IllegalStateException.class,
                () -> underTest.showPokemonStatus(pokemon));
    }
}