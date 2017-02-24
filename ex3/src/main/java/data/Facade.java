package data;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Peter
 */
public class Facade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void createPerson(Person person) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public Person getPerson(int id) {  //returns null if no matching id, not sure if okay
        EntityManager em = getEntityManager();
        Person person;
        try {
            person = em.find(Person.class, id);
        } finally {
            em.close();
        }
        return person;
    }
    public void editPerson(Person person) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public void deletePerson(Person person) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public void deletePerson(int id) {  //alternate
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(getPerson(id));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
