package org.example.service;

import com.google.gson.Gson;
import org.example.model.AdestradorFull;
import org.example.model.PokemonFull;
import org.example.repository.PokemonFullRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class PokemonFullService {

    @Autowired
    private final PokemonFullRepository PokemonFullRepo;

    public PokemonFullService(PokemonFullRepository PokemonFullRepo) {
        this.PokemonFullRepo = PokemonFullRepo;
    }

    public void crearPokemon(PokemonFull a) {
        PokemonFullRepo.save(a);
    }

    public PokemonFull buscarPokemon(String id) {
        return PokemonFullRepo.findById(id).orElse(null);
    }
    // Buscar Pokemon
    public List<PokemonFull> buscarPokemons() {
        return PokemonFullRepo.findAll();
    }

    // Buscar adestradorDePokemon
    public AdestradorFull buscarAdestradorDePokemon(String idPokemon) {
        PokemonFull Pokemon = buscarPokemon(idPokemon);
        if (Pokemon == null) return null;

        AdestradorFull adestrador = Pokemon.getAdestrador();

        return adestrador;
    }

    public void delete(){
        PokemonFullRepo.deleteBynome("Pikachu");
    }
    public PokemonFull getPokemonPikachu() {
        return PokemonFullRepo.findBynome("Pikachu");
    }

    public PokemonFull subirJson(){
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/main/java/org/example/Json/PokemonFull.json");
            PokemonFull pokemonFull = gson.fromJson(reader,PokemonFull.class);
            PokemonFullRepo.save(pokemonFull);
            return pokemonFull;
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado. "+e.getMessage());
            return null;
        }
    }

    public List<PokemonFull> bajarJson(){
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter("src/main/java/org/example/Json/PokemonFullCopy.json")) {
            List<PokemonFull> p = PokemonFullRepo.findAll();
            String json = gson.toJson(p);

            writer.write(json);
            return p;

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado. "+e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println("Error al escribir fichero. "+e.getMessage());
            return null;
        }
    }

}
