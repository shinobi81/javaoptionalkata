package net.kamigun.ex4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.stream.Stream;

class PokedexTest {
    public static final String SLEEP_STATUS = "SLEEP";
    private Pokedex underTest;

    @BeforeEach
    void setUp() {
        underTest = Mockito.spy(new Pokedex());
    }

    @ParameterizedTest
    @MethodSource("pokemonProvider")
    void showPokemonStatus(Pokemon pokemon, String statusExpected, Duration timeout, int elaborateStatusInteractions) {

        String result = Assertions.assertTimeoutPreemptively(
                timeout,
                () -> underTest.showPokemonStatus(pokemon)
        );
        Mockito.verify(underTest, Mockito.times(elaborateStatusInteractions)).elaborateStatus();
        Assertions.assertEquals(statusExpected, result);
    }

    private static Stream pokemonProvider() {
        return Stream.of(
                Arguments.of(new Pokemon(), "ELABORATED STATUS", Duration.ofMillis(3000), 1),
                Arguments.of(new Pokemon(SLEEP_STATUS), SLEEP_STATUS, Duration.ofMillis(1000), 0)
        );
    }
}