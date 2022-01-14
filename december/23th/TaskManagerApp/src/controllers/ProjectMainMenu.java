package controllers;

import concole.ConsoleColors;
import concole.ConsoleEntityManager;
import concole.impl.ConsoleProjectManagerImpl;

import entities.Project;
import entities.TaskDetails;
import entities.User;
import services.ProjectService;
import services.impl.ProjectServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectMainMenu extends AbstractMenu {
    private ConsoleEntityManager<Project> consoleProjectManager = new ConsoleProjectManagerImpl();
    private ProjectService<Project> projectService = new ProjectServiceImpl();
    private Map<Integer, String> projectMainMenu = new HashMap<>() {{
        put(0, "Create project");
        put(1, "Select project");
        put(2, "Main menu");
        put(3, "Exit");
    }};

    public ProjectMainMenu() {
        super();
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        System.out.println("**** PROJECT MENU ****");
        return projectMainMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            createProject();
        } else if (menuItemToDo == 1) {
            System.out.println("**** YOUR PROJECTS ****");
            List<Project> projects =  projectService.findProjectsByUser(getUser());
            if (projects != null && !projects.isEmpty()) {
                showAllProject(projects);
                Project selectedProject = consoleProjectManager.selectEntityFromListById(projects);
                goIntoMenuForSelectedProject(selectedProject);
            } else {
                System.out.println(ConsoleColors.RED + "You don't have projects. Create project!" + ConsoleColors.RESET);
            }
        } else if (menuItemToDo == 2) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 3) {
            System.exit(0);
        }
    }

    private void createProject() {
        System.out.println("**** NEW PROJECT ****");
        Project project = consoleProjectManager.getEntity();

        TaskDetails taskDetails = new TaskDetails(new Project(project), new User(getUser()));
        project.setTaskDetailsList(List.of(taskDetails));

        projectService.save(project);
    }

    private void showAllProject(List<Project> projects) {
        for (Project project : projects) {
            System.out.println("id - " + project.getId() + ", name - " + project.getName());
        }
    }

    private void goIntoMenuForSelectedProject(Project project) {
        MyProjectMenu myProjectMenu = new MyProjectMenu(project);
        myProjectMenu.startMenu();
    }
}
