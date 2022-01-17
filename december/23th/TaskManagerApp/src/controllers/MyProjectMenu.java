package controllers;

import entities.User;

import java.util.*;

public class MyProjectMenu extends AbstractMenu {
    private Map<Integer, String> projectMenu = new HashMap<>() {{
        put(0, "Board");
        put(1, "Edit project");
        put(2, "Change project manager");
        put(3, "Delete project");
        put(4, "Back to previous page");
        put(5, "Exit");
    }};

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        String projectName = getProject().getName().toUpperCase();
        printMenuTitle(projectName + " menu");
        return projectMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            BoardMenu boardMenu = new BoardMenu();
            boardMenu.startMenu();
        } else if (menuItemToDo == 1) {
            ProjectEditMenu projectEditMenu = new ProjectEditMenu();
            projectEditMenu.startMenu();
        } else if (menuItemToDo == 2) {
            ChangeProjectManagerMenu changeProjectManagerMenu = new ChangeProjectManagerMenu();
            changeProjectManagerMenu.startMenu();
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 3) {
            PROJECT_SERVICE.delete(getProject());
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 4) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 5) {
            System.exit(0);
        }
    }
}
