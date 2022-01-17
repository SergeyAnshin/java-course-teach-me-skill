package controllers;

import entities.Project;
import entities.User;

import java.util.*;

public class MyProjectMenu extends AbstractMenu {
    private Project project;
    private Map<Integer, String> projectMenu = new HashMap<>() {{
        put(0, "Board");
        put(1, "Edit project");
        put(2, "Change project manager");
        put(3, "Delete project");
        put(4, "Project main menu");
        put(5, "Exit");
    }};

    public MyProjectMenu(Project project) {
        this.project = project;
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        String projectName = project.getName().toUpperCase();
        printMenuTitle(projectName + " menu");
        return projectMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            BoardMenu boardMenu = new BoardMenu(project);
            boardMenu.startMenu();
        } else if (menuItemToDo == 1) {
            ProjectEditMenu projectEditMenu = new ProjectEditMenu(project);
            projectEditMenu.startMenu();
        } else if (menuItemToDo == 2) {
            ChangeProjectManagerMenu changeProjectManagerMenu = new ChangeProjectManagerMenu(project);
            changeProjectManagerMenu.startMenu();
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 3) {
            PROJECT_SERVICE.delete(project);
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 4) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 5) {
            System.exit(0);
        }
    }
}
