package net.kamigun.ex13;

import lombok.Getter;

import java.util.Optional;

/**
 * Do not declare any field of type {@link Optional}.
 */
public class Pokemon {

    @Getter
    private Optional<String> name = Optional.of("Pikachu");
}
