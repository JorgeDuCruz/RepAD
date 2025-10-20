import Services.AdestradorServices;
import Services.PokedexServices;
import Services.PokemonServices;
import models.Adestrador;
import models.Pokedex;
import models.Pokemon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PokedexServices pokedexServices = new PokedexServices();
        AdestradorServices adestradorServices = new AdestradorServices();
        PokemonServices pokemonServices = new PokemonServices();

        //pokemonServices.borrarPokemon(5);
        //pokemonServices.borrarPokemon(6);
        /*
        pokedexServices.AñadirPokedex("Eevee",2.5,"Pokemon evolución");
        adestradorServices.AñadirAdestrador("Pepe","21-5-2000");
        pokemonServices.AñadirPokemon("José","1999-5-21",1,1);
        pokemonServices.AñadirPokemon("Luis","1999-1-10",2,1);
         */

        for (Pokemon pokemon:pokemonServices.leerPokemons()){
            System.out.println(pokemon);
        }

        for (Pokedex pokedex:pokedexServices.leerPokedexs()){
            System.out.println(pokedex);
        }

        for (Adestrador adestrador:adestradorServices.leerAdestradores()){
            System.out.println(adestrador);
        }
    }
}
