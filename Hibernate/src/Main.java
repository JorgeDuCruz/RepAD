import Services.PokedexServices;
import Services.PokemonServices;
import models.Pokedex;
import models.Pokemon;

public class Main {
    public static void main(String[] args) {
        //new PokedexServices().AñadirPokemon(new Pokedex("Pikachu",4.5,"Rata amante del ketchup"));
        System.out.println(new PokedexServices().leerPokedex(1));


    }
}
