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
        put(3, "Change project manager");
        put(4, "My project menu");
        put(5, "Exit");
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
            }
        } else if (menuItemToDo == 3) {
            changeProjectManager();
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
