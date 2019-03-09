package net.kamigun.ex12;

import java.util.Optional;

/**
 * Avoid chaining {@link Optional}'s methods with the single purpose of getting a value.
 */
public class Pokemon {

    public static final String DEFAULT_STATUS = "PENDING";
    private String status;

    public Pokemon(String status) {
        this.status = status;
    }

    public String getStatus() {
        return Optional.ofNullable(status).orElse(DEFAULT_STATUS);
    }
}
