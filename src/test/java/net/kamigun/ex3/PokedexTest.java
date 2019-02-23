package net.kamigun.ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PokedexTest {

    public static final String SLEEP_STATUS = "SLEEP";
    private Pokedex underTest;

    @BeforeEach
    void setUp() {
        underTest = new Pokedex();
    }

    @ParameterizedTest
    @MethodSource("pokemonProvider")
    void showPokemonStatus(Pokemon pokemon, String statusExpected) {
        String result = underTest.showPokemonStatus(pokemon);

        Assertions.assertEquals(statusExpected, result);
    }

    private static Stream pokemonProvider() {
        return Stream.of(
                Arguments.of(new Pokemon(), Pokedex.UNKNOWN_POKEMON_STATUS),
                Arguments.of(new Pokemon(SLEEP_STATUS), SLEEP_STATUS)
        );
    }
}