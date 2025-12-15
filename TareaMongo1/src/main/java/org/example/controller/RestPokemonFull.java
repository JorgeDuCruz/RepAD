package org.example.controller;


import org.example.model.AdestradorFull;
import org.example.model.PokemonFull;
import org.example.service.PokemonFullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPokemonFull.MAPPING)
public class RestPokemonFull {

    public static final String MAPPING = "/mongodb/pokemonFull";

    @Autowired
    private PokemonFullService pokemonService;

    @PostMapping("/gardar")
    public ResponseEntity<PokemonFull> gardar(@RequestBody PokemonFull pokemon) {
        pokemonService.crearPokemon(pokemon);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<PokemonFull>> listarColeccion() {
        List <PokemonFull> pokemons = pokemonService.buscarPokemons();
        return new ResponseEntity<>(pokemons,HttpStatus.OK);
    }


    @GetMapping("/getAdestradorDePokemon/{id}")
    public ResponseEntity<AdestradorFull> actualizarGrupo(@PathVariable String id) {
        AdestradorFull p = pokemonService.buscarAdestradorDePokemon(id);

        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @PostMapping("/subirJson")
    public ResponseEntity<PokemonFull> subirJson(){
        PokemonFull p = pokemonService.subirJson();
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/bajarJson")
    public ResponseEntity<List<PokemonFull>> bajarJson(){
        List<PokemonFull> p = pokemonService.bajarJson();
        if (p==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

}
