package Services;

import config.HibernateConfig;
import models.Adestrador;
import models.Pokedex;
import models.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokemonServices {

    public void AñadirPokemon(String nome, String dataNacemento,int pokedexentry, int adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokemon pokemon = new Pokemon();
            Pokedex pokedexaux = new PokedexServices().leerPokedex(pokedexentry);
            Adestrador adestradoraux = new AdestradorServices().leerAdestrador(adestrador);
            pokemon.setNome(nome);
            pokemon.setNacemento(dataNacemento);
            pokemon.setAdestrador(adestradoraux);
            pokemon.setPokedexentry(pokedexaux);

            session.save(pokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error para insertar Pokemon: " + e.getMessage());
        }
    }

    public Pokemon leerPokemon(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokemon.class,id);
        }catch (Exception e){
            System.out.println("Erro al leer el pokemon "+id+": "+e.getMessage());
            return null;
        }
    }

    public Pokemon leerPokemon(String nome) {
        Pokemon pokemon = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Pokemon> list = session.createQuery("from Pokemon where nome = :nome",Pokemon.class)
                    .setParameter("nome",nome).getResultList();
            if (!list.isEmpty()){
                pokemon=list.get(0);
            }else {
                System.out.println("No se encontró el adestrador de nome: "+nome);
            }
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro al leer el adestrador "+nome+": "+e.getMessage());
            return null;
        }
        return pokemon;
    }

    public List<Pokemon> leerPokemons(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            return session.createQuery("from Pokemon", Pokemon.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al leer la tabla pokemon");
            return null;
        }
    }

    public void ActualizarPokemon(Pokemon pokemon){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(pokemon);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al actualizar adestrador "+e.getMessage());
        }
    }

    public void borrarPokemon(int id){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Pokemon pokemon = session.get(Pokemon.class,id);
            if (pokemon!=null){
                session.delete(pokemon);
            }
            else {
                System.out.println("No se encontró pokemon");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar entrada de pokemon: "+e.getMessage());
        }
    }
}
