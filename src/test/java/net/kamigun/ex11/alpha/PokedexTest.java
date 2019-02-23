package net.kamigun.ex11.alpha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokedexTest {

    private Pokedex underTest;

    @BeforeEach
    void setUp() {
        underTest = new Pokedex();
    }

    @ParameterizedTest
    @MethodSource("pokemonProvider")
    void getPowerfulPokemon(int attackStat, String expectedName) {
        String result = underTest.getPowerfulPokemon(attackStat);

        assertEquals(expectedName, result);
    }

    private static Stream pokemonProvider() {
        return Stream.of(
                Arguments.of(90, Pokedex.CHARMANDER.getName()),
                Arguments.of(110, Pokedex.NOT_FOUND)
        );
    }
}