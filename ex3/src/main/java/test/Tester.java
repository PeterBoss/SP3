package test;

import data.Facade;
import entity.Person;
import entity.Student;
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
        
        Facade fac = new Facade(Persistence.createEntityManagerFactory("pu"));
        
        Person person1 = new Student();
        person1.setFirstName("Peter");
        fac.createPerson(person1);
        
        System.out.println(fac.getPerson(1).getFirstName());
        
        person1.setFirstName("Michael");
        fac.editPerson(person1);
        
        System.out.println(fac.getPerson(1).getFirstName());
    }
    
}
