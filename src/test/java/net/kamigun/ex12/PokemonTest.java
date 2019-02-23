package net.kamigun.ex12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokemonTest {

    public static final String SLEEP = "SLEEP";
    private Pokemon underTest;

    @ParameterizedTest
    @MethodSource("dataProvider")
    void getStatus(String status, String expectedResult) {
        underTest = new Pokemon(status);

        String result = underTest.getStatus();

        assertEquals(expectedResult, result);
    }

    private static Stream dataProvider() {
        return Stream.of(
                Arguments.of(SLEEP, SLEEP),
                Arguments.of(null, Pokemon.DEFAULT_STATUS)
        );
    }
}