package net.kamigun.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

class PokeballTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Pokeball underTest;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));

        underTest = new Pokeball();
    }

    @Test
    void testEmptyPokeball() {
        Optional<Pokemon> myPokemon = underTest.getPokemon();
        myPokemon.ifPresent(System.out::println);

        Assertions.assertEquals("", outContent.toString());
    }

    @BeforeEach
    void restoreStreams() {
        System.setOut(originalOut);
    }
}