package net.kamigun.ex2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokeballTest {

    private Pokeball underTest;

    @ParameterizedTest
    @MethodSource("pokemonProvider")
    void getPokemonName(Optional<Pikachu> optionalPikachu, String expected) {
        underTest = new Pokeball(optionalPikachu);

        String result = underTest.getPokemonName();

        assertEquals(expected, result);
    }

    private static Stream pokemonProvider() {
        return Stream.of(
                Arguments.of(Optional.empty(), ""),
                Arguments.of(Optional.of(new Pikachu()), "Pikachu")
        );
    }
}