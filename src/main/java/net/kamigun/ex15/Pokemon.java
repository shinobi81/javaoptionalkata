package net.kamigun.ex15;

import java.io.Serializable;
import java.util.Optional;

/**
 * {@link Optional} is not intended for use as a property of a Java Bean or as the persistent property type.
 * {@link Optional} is not {@link Serializable}.
 * Do not use {@link Optional} in setters.
 */
public class Pokemon implements Serializable {

    private Optional<String> name;

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }
}
