package net.kamigun.ex12;

import java.util.Optional;

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
