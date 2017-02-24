package test;

import entity.Customer;
import entity.DiscountFixed;
import entity.DiscountQuantity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Peter
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            
            Customer cust = new Customer();
            cust.addDiscount(new DiscountFixed());
            cust.addDiscount(new DiscountQuantity());
            em.persist(cust);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
    }
    
}
