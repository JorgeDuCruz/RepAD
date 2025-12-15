package org.example.service;

import org.example.model.AdestradorFull;
import org.example.model.PokemonFull;
import org.example.repository.PokemonFullRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
