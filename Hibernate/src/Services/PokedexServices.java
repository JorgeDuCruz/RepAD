package Services;

import config.HibernateConfig;
import models.Pokedex;
import models.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokedexServices {

    public void AñadirPokemon(Pokedex pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(pokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error para insertar pokemon en la pokedex: " + e.getMessage());
        }
    }

    public Pokedex leerPokemon(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class,id);
        }catch (Exception e){
            System.out.println("Erro al leer el pokemon de la pokedex"+id+": "+e.getMessage());
            return null;
        }
    }

    public List<Pokedex> leerPokemons(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            return session.createQuery("from pokemon", Pokedex.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al leer la tabla pokemon");
            return null;
        }
    }

    public void ActualizarPokemon(Pokedex pokedex){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(pokedex);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al actualizar pokemon en la pokedex");
        }
    }

}
