package controllers;

import concole.ConsoleColors;
import concole.ConsoleEntityManager;
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

public class MyProjectMenu extends AbstractMenu {
    private Project project;
    private ProjectService<Project> projectService = new ProjectServiceImpl();
    private ConsoleEntityManager<User> consoleUserManager = new ConsoleUserManagerImpl();
    private UserService<User> userService = new UserServiceImpl();
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
            changeProjectManager();
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 3) {
            projectService.delete(project);
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 4) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 5) {
            System.exit(0);
        }
    }

    private void changeProjectManager() {
        List<Boolean> toTransferProject = new ArrayList<>(List.of(Boolean.TRUE));
        User user;
        while (toTransferProject.get(0)) {
            user = getNewProjectManager(toTransferProject);
            if (user != null) {
                projectService.transferProjectToUser(project, user);
                System.out.println("The project has been transferred to " + user.getLogin());
                break;
            }
        }
    }

    private User getNewProjectManager(List<Boolean> toTransferProject) {
        System.out.println("**** FIND A NEW PROJECT MANAGER ****");
        System.out.println("0 - Among project employees");
        System.out.println("1 - Global search");
        System.out.println("2 - Don't search");
        long actionNumber = CONSOLE_OPERATION.getNumberFromTo(0, 2);
        if (actionNumber == 0) {
            return getNewProjectManagerFromProjectMembers();
        } else if (actionNumber == 1) {
            return getNewProjectManagerFromGlobalSearch();
        } else {
            toTransferProject.set(0, Boolean.FALSE);
            return null;
        }
    }

    private User getNewProjectManagerFromProjectMembers() {
        List<User> executors = project.getTaskDetailsList()
                .stream()
                .map(TaskDetails::getExecutor)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (!executors.isEmpty()) {
            showPossibleProjectManagers(executors);
            return consoleUserManager.selectEntityFromListById(executors);
        }
        System.out.println(ConsoleColors.RED + "There are no employees on the project!" + ConsoleColors.RESET);
        return null;
    }

    private User getNewProjectManagerFromGlobalSearch() {
        String login = consoleUserManager.getStringValueForFieldFromConsole("login");
        User user = userService.findByLogin(login);
        if (user != null) {
            showPossibleProjectManagers(List.of(user));
            System.out.println("0 - Transfer the project");
            System.out.println("1 - Find another user");
            long actionNumber = CONSOLE_OPERATION.getNumberFromTo(0, 1);
            if (actionNumber == 0) {
                return user;
            }
        } else {
            System.out.println(ConsoleColors.RED + "User isn't found!" + ConsoleColors.RESET);
        }
        return null;
    }


    private void showPossibleProjectManagers(List<User> projectManagers) {
        for (User projectManager : projectManagers) {
            System.out.println("id - " + projectManager.getId() + ", login - " + projectManager.getLogin());
        }
    }
}
