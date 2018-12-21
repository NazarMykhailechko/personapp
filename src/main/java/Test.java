import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persondb");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            em.persist(new Person("Nazar", 35));
            em.persist(new Person("Alyona", 29));
            em.persist(new Person("Olya", 51));
            em.persist(new Person("Andy", 40));
            em.persist(new Person("Igor", 42));

            et.commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            et.rollback();
        }finally {
               em.close();
        }
    }
}