package org.example.service;

import org.example.model.Adestrador;
import org.example.model.Pokemon;
import org.example.repository.AdestradorRepository;
import org.example.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository PokemonRepo;
    private final AdestradorRepository adestradorRepo;

    public PokemonService(PokemonRepository PokemonRepo, AdestradorRepository adestradorRepo) {
        this.PokemonRepo = PokemonRepo;
        this.adestradorRepo = adestradorRepo;
    }

    public void crearPokemon(Pokemon a) {
        PokemonRepo.save(a);
    }

    public Pokemon buscarPokemon(String id) {
        return PokemonRepo.findById(id).orElse(null);
    }
    // Buscar Pokemon
    public List<Pokemon> buscarPokemons() {
        return PokemonRepo.findAll();
    }

    // Buscar adestradorDePokemon
    public Adestrador buscarAdestradorDePokemon(String idPokemon) {
        Pokemon Pokemon = buscarPokemon(idPokemon);
        if (Pokemon == null) return null;

        Adestrador adestrador = adestradorRepo.findById(Pokemon.getId_adestrador()).orElse(null);

        return adestrador;
    }

}
