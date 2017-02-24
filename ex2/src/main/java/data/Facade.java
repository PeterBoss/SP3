package data;

import entity.Project;
import entity.ProjectUser;
import entity.Task;
import java.util.List;
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

    public void createUser(ProjectUser user) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public ProjectUser getUser(int id) {
        EntityManager em = getEntityManager();
        ProjectUser user;
        try {
            user = em.find(ProjectUser.class, id);
        } finally {
            em.close();
        }
        return user;
    }
    
    public List<ProjectUser> getAllUsers() {
        EntityManager em = getEntityManager();
        List<ProjectUser> users;
        try {
            users = em.createQuery("SELECT u FROM ProjectUser u").getResultList();
        } finally {
            em.close();
        }
        return users;
    }
    
    public void createProject(Project project) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void assignUserToProject(ProjectUser user, Project project) {
        EntityManager em = getEntityManager();
        user.addProject(project);
        project.addContributor(user);
        try {
            em.getTransaction().begin();
            em.merge(project);
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public Project getProject(int id) {
        EntityManager em = getEntityManager();
        Project project;
        try {
            project = em.find(Project.class, id);
        } finally {
            em.close();
        }
        return project;
    }
    
    public void createTaskAndAssignToProject(Task task, Project project) {
        EntityManager em = getEntityManager();
        project.addTask(task);
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.merge(project);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
}
