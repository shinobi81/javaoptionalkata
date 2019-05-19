package net.kamigun.ex15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PokedexTest {
    private Pokedex underTest;

    @BeforeEach
    void setUp() {
        underTest = new Pokedex();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(Pokedex.FILE_NAME));
    }

    @Test
    void savePokemonPikachu() throws InvocationTargetException, IllegalAccessException, IOException, ClassNotFoundException {
        String pokemonName = "Pikachu";
        Pokemon pokemon = new Pokemon();
        setPokemonName(pokemonName, pokemon);

        Pokemon savedPokemon = underTest.savePokemon(pokemon);

        assertNotNull(savedPokemon);
        assertEquals(Optional.ofNullable(pokemonName), savedPokemon.getName());
    }

    @Test
    void savePokemonNullName() throws InvocationTargetException, IllegalAccessException, IOException, ClassNotFoundException {
        String pokemonName = null;
        Pokemon pokemon = new Pokemon();
        setPokemonName(pokemonName, pokemon);

        Pokemon savedPokemon = underTest.savePokemon(pokemon);

        assertNotNull(savedPokemon);
        assertEquals(Optional.ofNullable(pokemonName), savedPokemon.getName());
    }

    private void setPokemonName(String pokemonName, Pokemon pokemon) throws IllegalAccessException, InvocationTargetException {
        Class<? extends Pokemon> pokemonClass = pokemon.getClass();
        try {
            Method setNameMethod = pokemonClass.getMethod("setName", Optional.class);
            setNameMethod.invoke(pokemon, Optional.ofNullable(pokemonName));

        } catch (NoSuchMethodException e) {
            // do nothing
        }
        try {
            Method setNameMethod = pokemonClass.getMethod("setName", String.class);
            setNameMethod.invoke(pokemon, pokemonName);

        } catch (NoSuchMethodException e) {
            // do nothing
        }
    }
}
