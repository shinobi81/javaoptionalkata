package net.kamigun.ex14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Constructor;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PokemonTest {
    Pokemon pokemon;

    @ParameterizedTest
    @MethodSource("pokemonParams")
    void getOwner(String name, String owner, boolean expectedException) throws Exception {
        Object testOwner;

        Constructor<?> pokemonConstructor = Pokemon.class.getDeclaredConstructors()[0];
        if (pokemonConstructor.getParameterTypes()[1].equals(Optional.class)) {
            testOwner = Optional.ofNullable(owner);
        } else {
            testOwner = owner;
        }

        if (expectedException) {
            Exception exception = assertThrows(Exception.class, () -> pokemonConstructor.newInstance(name, testOwner));
            assertEquals(NullPointerException.class, ExceptionUtils.getRootCause(exception).getClass());

        } else {
            pokemon = (Pokemon) pokemonConstructor.newInstance(name, testOwner);

            assertEquals(Optional.ofNullable(owner), pokemon.getOwner());
        }
    }

    private static Stream pokemonParams() {
        return Stream.of(
            Arguments.of("Pikachu", "Ash Ketchum", false),
            Arguments.of("Pikachu", null, false),
            Arguments.of(null, "Ash Ketchum", true),
            Arguments.of(null, null, true)
        );
    }
}
