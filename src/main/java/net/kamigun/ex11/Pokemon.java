package net.kamigun.ex11;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class Pokemon {
    private String name;
    private int attackStat;

    public Pokemon(String name, int attackStat) {
        this.name = name;
        this.attackStat = attackStat;
    }
}
