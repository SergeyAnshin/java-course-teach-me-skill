package controllers;

import entities.Project;
import entities.User;

import java.util.HashMap;
import java.util.Map;

public class MyProjectMenu extends AbstractMenu {
    private Project project;
    private Map<Integer, String> projectMenu = new HashMap<>() {{
        put(0, "Board");
        put(1, "Edit project");
        put(2, "Project menu");
        put(3, "Exit");
    }};

    public MyProjectMenu(Project project) {
        this.project = project;
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        String projectName = project.getName().toUpperCase();
        System.out.println("**** " + projectName + " MENU ****");
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
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 3) {
            System.exit(0);
        }
    }
}
