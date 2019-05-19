package net.kamigun.ex15;

import java.io.*;

public class Pokedex {

    public static final String FILE_NAME = "pokedex.dat";

    public Pokemon savePokemon(Pokemon pokemon) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            objectOutputStream.writeObject(pokemon);
        }

        Pokemon readPokemon;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            readPokemon = (Pokemon) objectInputStream.readObject();
        }

        return readPokemon;
    }
}
