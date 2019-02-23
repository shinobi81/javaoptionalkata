package net.kamigun.ex10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

class PokedexTest {

    public static final String SLEEP_STATUS = "SLEEP";
    public static final Optional<String> EXPECTED_STATUS = Optional.of(SLEEP_STATUS);
    private Pokedex underTest;

    @BeforeEach
    void setUp() {
        underTest = new Pokedex();
    }

    @ParameterizedTest
    @MethodSource("pokemonProvider")
    void showPokemonStatus(Pokemon pokemon, Optional<String> statusExpected) {
        Optional<String> result = underTest.showPokemonStatus(pokemon);

        Assertions.assertEquals(statusExpected, result);
    }

    private static Stream pokemonProvider() {
        return Stream.of(
                Arguments.of(new Pokemon(), Pokedex.DEFAULT_STATUS),
                Arguments.of(new Pokemon(SLEEP_STATUS), EXPECTED_STATUS)
        );
    }
}