package controllers;

import entities.Project;
import entities.User;

import java.util.*;

public class ProjectEditMenu extends AbstractMenu {
    private Project newProject;
    private Map<Integer, String> projectEditMenu = new HashMap<>() {{
        put(0, "Edit name");
        put(1, "Edit key");
        put(2, "Save changes");
        put(3, "Back to previous page");
        put(4, "Exit");
    }};

    public ProjectEditMenu() {
        this.newProject = new Project(getProject());
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        printMenuTitle("edit project");
        System.out.println("Project name - " + newProject.getName() + ", project key - " + newProject.getKey());
        return projectEditMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            printMenuTitle("edit name");
            String name = CONSOLE_PROJECT_MANAGER.getStringValueForFieldFromConsole("name");
            newProject.setName(name);
        } else if (menuItemToDo == 1) {
            printMenuTitle("edit key");
            String key = CONSOLE_PROJECT_MANAGER.getStringValueForFieldFromConsole("key");
            newProject.setKey(key);
        } else if (menuItemToDo == 2) {
            PROJECT_SERVICE.update(newProject);
        } else if (menuItemToDo == 3) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 4) {
            System.exit(0);
        }
    }
}
