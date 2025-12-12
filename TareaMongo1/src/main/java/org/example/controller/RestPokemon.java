package org.example.controller;

import org.example.model.Pokemon;
import org.example.model.Adestrador;
import org.example.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPokemon.MAPPING)
public class RestPokemon {

    public static final String MAPPING = "/mongodb/pokemon";

    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/gardar")
    public ResponseEntity<Pokemon> gardar(@RequestBody Pokemon pokemon) {
        pokemonService.crearPokemon(pokemon);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Pokemon>> listarColeccion() {
        List <Pokemon> pokemons = pokemonService.buscarPokemons();
        return new ResponseEntity<>(pokemons,HttpStatus.OK);
    }


    @GetMapping("/getAdestradorDePokemon/{id}")
    public ResponseEntity<Adestrador> actualizarGrupo(@PathVariable String id) {
        Adestrador p = pokemonService.buscarAdestradorDePokemon(id);

        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

}
