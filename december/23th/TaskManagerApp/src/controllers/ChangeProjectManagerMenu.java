package controllers;

import concole.ConsoleColors;
import entities.Project;
import entities.TaskDetails;
import entities.User;

import java.util.*;
import java.util.stream.Collectors;

public class ChangeProjectManagerMenu extends AbstractMenu {
    private Map<Integer, String> findNewProjectManagerMenu =  new HashMap<>() {{
        put(0, "Among project members");
        put(1, "Global search");
        put(2, "Don't search");
    }};

    public ChangeProjectManagerMenu() {}

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        printMenuTitle("find a new project manager");
        return findNewProjectManagerMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            List<User> projectMembers = getProject().getTaskDetailsList()
                    .stream()
                    .map(TaskDetails::getExecutor)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            User newProjectManager = findNewProjectManagerAmong(projectMembers);
            transferProjectToAnotherOwner(getProject(), newProjectManager);
        } else if (menuItemToDo == 1) {
            String loginNewProjectManager = CONSOLE_USER_MANAGER.getStringValueForFieldFromConsole("login");
            User user = USER_SERVICE.findByLogin(loginNewProjectManager) ;
            User newProjectManager = findNewProjectManagerAmong(user != null && !user.equals(getUser()) ?
                    List.of(user) : Collections.emptyList());
            transferProjectToAnotherOwner(getProject(), newProjectManager);
        } else if (menuItemToDo == 2) {
            setWorkingInThisMenu(false);
        }
    }

    private User findNewProjectManagerAmong(List<User> potentialProjectOwners) {
        if (!potentialProjectOwners.isEmpty()) {
            CONSOLE_USER_MANAGER.printEntityInfo(potentialProjectOwners);
            return CONSOLE_USER_MANAGER.selectEntityFromListById(potentialProjectOwners);
        } else {
            return null;
        }
    }

    private void transferProjectToAnotherOwner(Project project, User newProjectManager) {
        if (newProjectManager != null) {
            PROJECT_SERVICE.transferProjectToUser(project, newProjectManager);
            setWorkingInThisMenu(false);
        } else {
            System.out.println(ConsoleColors.RED + "No user to transfer the project!" + ConsoleColors.RESET);
        }
    }

}
