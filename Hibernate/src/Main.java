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

        //Pokedex
        /*
        pokedexServices.AñadirPokedex("Pikachu",5,"Rata amante del ketchup");
        pokedexServices.AñadirPokedex("Eevee",2.5,"Pokemon evolución");
        pokedexServices.AñadirPokedex("Raichu",50,"Rata arrogante");
        pokedexServices.AñadirPokedex("HO-OH",250.26,"Pajaro arcoíris");
        pokedexServices.AñadirPokedex("Mew",7.5,"Es un gato divino, osea DIOS");
        pokedexServices.AñadirPokedex("Arceus",100,"Una llama que dice ser dios, nadie la quiere");
        pokedexServices.AñadirPokedex("Yveltal",200.9,"Fue traicionado y encerrado en la habitación del tiempo");
        pokedexServices.AñadirPokedex("Linoone",50,"El mejor amigo del hombre");
        pokedexServices.AñadirPokedex("Mightyena",40.6,"Tiene mucha aura");
        pokedexServices.AñadirPokedex("Manectric",42.7,"Colmillo trueno y pal rio");

        //Adestrador
        adestradorServices.AñadirAdestrador("Pepe","2000-5-21");
        adestradorServices.AñadirAdestrador("Manuel","1995-2-14");

*/
        //Pokemon
        pokemonServices.AñadirPokemon("José","1999-5-21",14,5);
        pokemonServices.AñadirPokemon("Luis","1999-1-10",15,5);
        pokemonServices.AñadirPokemon("Juan","1995-3-30",19,5);
        pokemonServices.AñadirPokemon("Dios","1995-5-20",18,5);
        pokemonServices.AñadirPokemon("Pre-vaporeon","1998-3-30",15,5);
        pokemonServices.AñadirPokemon("Pikachu-Temu","1995-3-30",23,5);

        pokemonServices.AñadirPokemon("José","1999-5-21",16,6);
        pokemonServices.AñadirPokemon("Luis","1999-1-10",17,6);
        pokemonServices.AñadirPokemon("Juan","1995-3-30",19,6);
        pokemonServices.AñadirPokemon("Dios","1995-5-20",21,6);
        pokemonServices.AñadirPokemon("Perro","1998-3-30",22,6);
        pokemonServices.AñadirPokemon("Goku","1995-3-30",20,6);



        for (Pokemon pokemon:pokemonServices.leerPokemons()){
            System.out.println(pokemon);
            //pokemonServices.borrarPokemon(pokemon.getId());
        }

        for (Pokedex pokedex:pokedexServices.leerPokedexs()){
            System.out.println(pokedex);
            //pokedexServices.borrarPokedex(pokedex.getId());
        }

        for (Adestrador adestrador:adestradorServices.leerAdestradores()){
            System.out.println(adestrador);
            //adestradorServices.borrarAdestrador(adestrador.getId());
        }
    }
}
