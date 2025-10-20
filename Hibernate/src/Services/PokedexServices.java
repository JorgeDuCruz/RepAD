package Services;

import config.HibernateConfig;
import models.Pokedex;
import models.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokedexServices {

    public void AñadirPokedex(String nome, double peso, String misc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokedex pokedex = new Pokedex();
            pokedex.setMisc(misc);
            pokedex.setNome(nome);
            pokedex.setPeso(peso);

            session.save(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error para insertar pokemon en la pokedex: " + e.getMessage());
        }
    }

    public Pokedex leerPokedex(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class,id);
        }catch (Exception e){
            System.out.println("Erro al leer el pokemon de la pokedex"+id+": "+e.getMessage());
            return null;
        }
    }

    public List<Pokedex> leerPokedexs(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            return session.createQuery("from pokemon", Pokedex.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al leer la tabla pokemon");
            return null;
        }
    }

    public void ActualizarPokedex(Pokedex pokedex){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(pokedex);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al actualizar pokemon en la pokedex: "+e.getMessage());
        }
    }

    public void borrarPokedex(int id){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Pokedex pokedex = session.get(Pokedex.class,id);
            if (pokedex!=null){
                session.delete(pokedex);
            }
            else {
                System.out.println("No se encontró la entrada de pokedex");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar entrada de pokedex: "+e.getMessage());
        }
    }

}
