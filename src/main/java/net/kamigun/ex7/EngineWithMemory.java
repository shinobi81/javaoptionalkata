package net.kamigun.ex7;

import lombok.Getter;

public class EngineWithMemory {

    @Getter
    private int lastResult;

    public int sum(int a, int b) {
        lastResult = a + b;
        return lastResult;
    }
}
