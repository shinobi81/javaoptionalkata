package net.kamigun.ex8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokedexTest {
    public static final String SLEEP_STATUS = "SLEEP";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Pokedex underTest;

    @BeforeEach
    void setUp() {
        underTest = new Pokedex(new PrintStream(outContent));
    }

    @ParameterizedTest
    @MethodSource("pokemonProvider")
    void showPokemonStatus(Pokemon pokemon, String statusExpected) {

        underTest.showPokemonStatus(pokemon);

        assertEquals(statusExpected, outContent.toString());
    }

    private static Stream pokemonProvider() {
        return Stream.of(
                Arguments.of(new Pokemon(), ""),
                Arguments.of(new Pokemon(SLEEP_STATUS), SLEEP_STATUS)
        );
    }
}