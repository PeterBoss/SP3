package test;

import data.Facade;
import entity.Project;
import entity.ProjectUser;
import entity.Task;
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
        
        ProjectUser user1 = new ProjectUser();
        ProjectUser user2 = new ProjectUser();
        Project project1 = new Project();
        Project project2 = new Project();
        Task task1 = new Task();
        
        task1.setName("Test Task");
        
        project1.setName("Test Project");
        
        fac.createUser(user1);
        fac.createUser(user2);
        fac.createProject(project1);
        fac.createProject(project2);
        
        fac.assignUserToProject(user1, project1);
        fac.assignUserToProject(user1, project2);
        fac.assignUserToProject(user2, project2);
        fac.createTaskAndAssignToProject(task1, project1);
        
        System.out.println(fac.getProject(1).getName());
        System.out.println(fac.getUser(1).getProjects().get(0).getName());
        System.out.println(fac.getProject(1).getTasks().get(0).getName());
    }
    
}
