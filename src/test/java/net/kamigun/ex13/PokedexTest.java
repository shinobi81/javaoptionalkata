package net.kamigun.ex13;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class PokedexTest {

    private Pokedex underTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(Pokedex.FILE_NAME));
    }

    @Test
    void savePokemon() throws IOException, ClassNotFoundException {
        underTest = new Pokedex();
        Pokemon pokemon = new Pokemon();

        Pokemon savedPokemon = underTest.savePokemon(pokemon);

        assertNotNull(savedPokemon);
        assertEquals(pokemon.getName(), savedPokemon.getName());
    }
}
