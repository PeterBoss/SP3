package test;

import data.Facade;
import entity.Student;
import entity.Studypoint;
import java.util.ArrayList;
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
        
        Student student = new Student();
        student.setStudypointCollection(new ArrayList());
        student.setFirstname("Peter");
        Studypoint studypoint = new Studypoint();
        studypoint.setScore(5);
        fac.createStudypoint(studypoint);
        student.addStudypoint(studypoint);
        fac.createStudent(student);
        
        System.out.println(fac.getStudentsWithFirstName("Peter"));
        System.out.println(fac.getStudypoints(1));
    }
    
}
