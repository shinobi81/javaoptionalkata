package net.kamigun.ex7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    public static final int ADDEND_A = 1;
    public static final int ADDEND_B = 2;
    public static final int EXPECTED_RESULT = ADDEND_A + ADDEND_B;

    private Calculator underTest;

    @BeforeEach
    void setUp() {
    }

    @Test
    void sumUsingEngineWithMemory() throws InvocationTargetException, IllegalAccessException {
        underTest = new Calculator(true);

        int result = underTest.sum(ADDEND_A, ADDEND_B);

        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    void sumUsingEngineWithoutMemory() throws InvocationTargetException, IllegalAccessException {
        underTest = new Calculator(false);

        int result = underTest.sum(ADDEND_A, ADDEND_B);

        assertEquals(EXPECTED_RESULT, result);
    }
}