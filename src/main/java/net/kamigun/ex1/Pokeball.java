package net.kamigun.ex1;

import lombok.Getter;

import java.util.Optional;

/**
 * Avoid the {@link NullPointerException}.
 */
public class Pokeball {

    @Getter
    private Optional<Pokemon> pokemon = null;

}
