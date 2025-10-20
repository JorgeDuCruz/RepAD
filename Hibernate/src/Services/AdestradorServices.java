package Services;

import config.HibernateConfig;
import models.Adestrador;
import models.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdestradorServices {

    public void AñadirAdestrador(String nome, String dataNacemento) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Adestrador adestrador = new Adestrador();
            adestrador.setNome(nome);
            adestrador.setNacemento(dataNacemento);

            session.save(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error para insertar Adestrador: " + e.getMessage());
        }
    }

    public Adestrador leerAdestrador(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Adestrador.class,id);
        }catch (Exception e){
            System.out.println("Erro al leer el adestrador "+id+": "+e.getMessage());
            return null;
        }
    }

    public List<Adestrador> leerAdestradores(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            return session.createQuery("from adestrador", Adestrador.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al leer la tabla adestrador");
            return null;
        }
    }

    public void ActualizarAdestrador(Adestrador adestrador){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(adestrador);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al actualizar adestrador "+e.getMessage());
        }
    }

    public void borrarAdestrador(int id){
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = session.get(Adestrador.class,id);
            if (adestrador!=null){
                session.delete(adestrador);
            }
            else {
                System.out.println("No se encontró adestrador");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar entrada de adestrador: "+e.getMessage());
        }
    }
}
