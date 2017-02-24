package data;

import entity.Student;
import entity.Studypoint;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
    
    public Student getStudent(int id) {
        EntityManager em = getEntityManager();
        Student student;
        try {
            student = em.find(Student.class, id);
        } finally {
            em.close();
        }
        return student;
    }
    
    public List<Student> getAllStudents() {
        EntityManager em = getEntityManager();
        List<Student> students;
        try {
            students = em.createNamedQuery("Student.findAll").getResultList();
        } finally {
            em.close();
        }
        return students;
    }

    public List<Student> getStudentsWithFirstName(String firstName) {
        EntityManager em = getEntityManager();
        List<Student> students;
        try {
            Query query = em.createNamedQuery("Student.findByFirstname");
            query.setParameter("firstname", firstName);
            students = query.getResultList();
        } finally {
            em.close();
        }
        return students;
    }

    public List<Student> getStudentsWithLastName(String lastName) {
        EntityManager em = getEntityManager();
        List<Student> students;
        try {
            Query query = em.createNamedQuery("Student.findByLastname");
            query.setParameter("lastname", lastName);
            students = query.getResultList();
        } finally {
            em.close();
        }
        return students;
    }

    public void createStudent(Student student) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void createStudypoint(Studypoint studypoint) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(studypoint);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public int getStudypoints(int id) {
        EntityManager em = getEntityManager();
        int total = 0;
        try {
            Studypoint[] points = (Studypoint[]) getStudent(id).getStudypointCollection().toArray();
            for (Studypoint p : points) {
                total += p.getScore();
            }
        } finally {
            em.close();
        }
        return total;
    }
    
    public int getTotalStudypoints() {
        EntityManager em = getEntityManager();
        int total = 0;
        try {
            Query query = em.createQuery("SELECT SUM(s.score) FROM Studypoint s");
            total = query.getFirstResult();
        } finally {
            em.close();
        }
        return total;
    }
}
