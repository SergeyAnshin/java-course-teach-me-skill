package controllers;

import concole.ConsoleColors;
import entities.Project;
import entities.TaskDetails;
import entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectMainMenu extends AbstractMenu {
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
        printMenuTitle("project menu");
        return projectMainMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            createProject();
        } else if (menuItemToDo == 1) {
            printMenuTitle("your projects");
            List<Project> projects =  PROJECT_SERVICE.findProjectsByUser(getUser());
            if (projects != null && !projects.isEmpty()) {
                CONSOLE_PROJECT_MANAGER.printEntityInfo(projects);
                Project selectedProject = CONSOLE_PROJECT_MANAGER.selectEntityFromListById(projects);
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
        printMenuTitle("new project");
        Project project = CONSOLE_PROJECT_MANAGER.getEntity();

        TaskDetails taskDetails = new TaskDetails(new Project(project), new User(getUser()));
        project.setTaskDetailsList(List.of(taskDetails));

        PROJECT_SERVICE.save(project);
    }

    private void goIntoMenuForSelectedProject(Project project) {
        MyProjectMenu myProjectMenu = new MyProjectMenu(project);
        myProjectMenu.startMenu();
    }
}
