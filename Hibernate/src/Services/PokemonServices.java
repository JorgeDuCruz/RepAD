package Services;

import config.HibernateConfig;
import models.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokemonServices {

    public void AñadirPokemon(Pokemon pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(pokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error para insertar pokemon: " + e.getMessage());
        }
    }

    public Pokemon leerPokemon(String id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokemon.class,id);
        }catch (Exception e){
            System.out.println("Erro al leer el pokemon "+id+": "+e.getMessage());
            return null;
        }
    }

    public List<Pokemon> leerPokemons(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            return session.createQuery("from pokemon", Pokemon.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al leer la tabla pokemon");
            return null;
        }
    }
}
