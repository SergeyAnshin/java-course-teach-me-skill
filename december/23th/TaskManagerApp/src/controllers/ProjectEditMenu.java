package controllers;

import concole.ConsoleColors;
import concole.ConsoleEntityManager;
import concole.impl.ConsoleProjectManagerImpl;
import concole.impl.ConsoleUserManagerImpl;
import entities.Project;
import entities.TaskDetails;
import entities.User;
import services.ProjectService;
import services.UserService;
import services.impl.ProjectServiceImpl;
import services.impl.UserServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

public class ProjectEditMenu extends AbstractMenu {
    private Project project;
    private Project newProject;
    private ConsoleEntityManager<Project> consoleProjectManager = new ConsoleProjectManagerImpl();
    private ConsoleEntityManager<User> consoleUserManager = new ConsoleUserManagerImpl();
    private ProjectService<Project> projectService = new ProjectServiceImpl();
    private UserService<User> userService = new UserServiceImpl();
    private Map<Integer, String> projectEditMenu = new HashMap<>() {{
        put(0, "Edit name");
        put(1, "Edit key");
        put(2, "Save changes");
        put(3, "My project menu");
        put(4, "Exit");
    }};

    public ProjectEditMenu(Project project) {
        this.project = project;
        this.newProject = new Project(project);
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        System.out.println("**** EDIT PROJECT ****");
        return projectEditMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            String name = consoleProjectManager.getStringValueForFieldFromConsole("name");
            newProject.setName(name);
        } else if (menuItemToDo == 1) {
            String key = consoleProjectManager.getStringValueForFieldFromConsole("key");
            newProject.setKey(key);
        } else if (menuItemToDo == 2) {
            if (!project.getName().equals(newProject.getKey()) || !project.getKey().equals(newProject.getKey())) {
                projectService.update(newProject);
                System.out.println("Project data updated!");
            }
        } else if (menuItemToDo == 3) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 4) {
            System.exit(0);
        }
    }
}
