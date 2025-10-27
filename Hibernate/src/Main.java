import Services.AdestradorServices;
import Services.PokedexServices;
import Services.PokemonServices;
import Services.SerivceSerializacionPokedex;
import models.Adestrador;
import models.Pokedex;
import models.Pokemon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PokedexServices pokedexServices = new PokedexServices();
        AdestradorServices adestradorServices = new AdestradorServices();
        PokemonServices pokemonServices = new PokemonServices();
        ObjectOutputStream serializar = null;
        try {
            serializar = new ObjectOutputStream(new FileOutputStream("Pokedex.dex",true));
        } catch (IOException e) {
            System.out.println("Error con el archivo para serializar pokedex "+e.getMessage());
        }

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


        //Pokemon
        pokemonServices.AñadirPokemon("José","1999-5-21",pokedexServices.leerPokedex("Pikachu").getId(), adestradorServices.leerAdestrador("Pepe").getId());
        pokemonServices.AñadirPokemon("Luis","1999-1-10",pokedexServices.leerPokedex("Eevee").getId(),adestradorServices.leerAdestrador("Pepe").getId());
        pokemonServices.AñadirPokemon("Juan","1995-3-30",pokedexServices.leerPokedex("Arceus").getId(),adestradorServices.leerAdestrador("Pepe").getId());
        pokemonServices.AñadirPokemon("Dios","1995-5-20",pokedexServices.leerPokedex("Mew").getId(),adestradorServices.leerAdestrador("Pepe").getId());
        pokemonServices.AñadirPokemon("Pre-vaporeon","1998-3-30",pokedexServices.leerPokedex("Eevee").getId(),adestradorServices.leerAdestrador("Pepe").getId());
        pokemonServices.AñadirPokemon("Pikachu-Temu","1995-3-30",pokedexServices.leerPokedex("Pikachu").getId(),adestradorServices.leerAdestrador("Pepe").getId());

        pokemonServices.AñadirPokemon("José","1999-5-21",pokedexServices.leerPokedex("Raichu").getId(),adestradorServices.leerAdestrador("Manuel").getId());
        pokemonServices.AñadirPokemon("Luis","1999-1-10",pokedexServices.leerPokedex("HO-OH").getId(),adestradorServices.leerAdestrador("Manuel").getId());
        pokemonServices.AñadirPokemon("Juan","1995-3-30",pokedexServices.leerPokedex("Arceus").getId(),adestradorServices.leerAdestrador("Manuel").getId());
        pokemonServices.AñadirPokemon("Dios","1995-5-20",pokedexServices.leerPokedex("Linoone").getId(),adestradorServices.leerAdestrador("Manuel").getId());
        pokemonServices.AñadirPokemon("Perro","1998-3-30",pokedexServices.leerPokedex("Mightyena").getId(),adestradorServices.leerAdestrador("Manuel").getId());
        pokemonServices.AñadirPokemon("Goku","1995-3-30",pokedexServices.leerPokedex("Yveltal").getId(),adestradorServices.leerAdestrador("Manuel").getId());





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
*/
        if (serializar!=null) {
            SerivceSerializacionPokedex.serializar(pokedexServices.leerPokedex("Yveltal"), serializar);
            SerivceSerializacionPokedex.serializar(pokedexServices.leerPokedex("Linoone"), serializar);
            try {
                serializar.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar conexion con serializar "+e.getMessage());
            }
        }

        for (Pokedex pokedex:SerivceSerializacionPokedex.desSerializar()){
            System.out.println(pokedex);
        }
    }
}
