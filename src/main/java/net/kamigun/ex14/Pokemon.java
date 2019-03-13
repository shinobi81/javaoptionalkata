package net.kamigun.ex14;

import java.util.Objects;
import java.util.Optional;

/**
 * Do not use {@link Optional} in constructors arguments.
 */
public class Pokemon {

    private final String name;              // cannot be null
    private final Optional<String> owner;   // optional field, thus may be null

    public Pokemon(String name, Optional<String> owner) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.owner = owner;
    }

    public Optional<String> getOwner() {
        return owner;
    }
}
