package net.kamigun.ex2;

import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * Ensure that an {@link Optional} has a value before calling {@link Optional#get()}.
 */
@AllArgsConstructor
public class Pokeball {

    private Optional<Pikachu> pikachu = Optional.empty();

    public String getPokemonName() {
        return pikachu.get().getName();
    }
}
