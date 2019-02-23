package net.kamigun.ex9;

import lombok.Getter;

import java.util.Optional;

public class Pokemon {

    @Getter
    Optional<String> status;

    public Pokemon() {
        this.status = Optional.empty();
    }

    public Pokemon(String status) {
        this.status = Optional.of(status);
    }
}
