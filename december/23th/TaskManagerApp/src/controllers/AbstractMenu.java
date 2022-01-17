package controllers;

import concole.ConsoleEntityManager;
import concole.ConsoleOperation;
import concole.impl.ConsoleProjectManagerImpl;
import concole.impl.ConsoleTaskCategoryManagerImpl;
import concole.impl.ConsoleTaskManagerImpl;
import concole.impl.ConsoleUserManagerImpl;
import entities.*;
import services.*;
import services.impl.*;

import java.util.Map;

public abstract class AbstractMenu {
    private static User user = new User();
    private static Project project;
    private Map<Integer, String> menu;
    private boolean isWorkingInThisMenu = true;

    public static final ConsoleOperation CONSOLE_OPERATION = new ConsoleOperation();
    public static final UserService<User> USER_SERVICE = new UserServiceImpl();
    public static final ProjectService<Project> PROJECT_SERVICE = new ProjectServiceImpl();
    public static final TaskCategoryService<TaskCategory> TASK_CATEGORY_SERVICE = new TaskCategoryServiceImpl();
    public static final TaskDetailsService<TaskDetails> TASK_DETAILS_SERVICE = new TaskDetailsServiceImpl();
    public static final TaskService<Task> TASK_SERVICE = new TaskServiceImpl();

    public static final ConsoleEntityManager<Project> CONSOLE_PROJECT_MANAGER = new ConsoleProjectManagerImpl();
    public static final ConsoleEntityManager<User> CONSOLE_USER_MANAGER = new ConsoleUserManagerImpl();
    public static final ConsoleEntityManager<Task> CONSOLE_TASK_MANAGER = new ConsoleTaskManagerImpl();
    public static final ConsoleEntityManager<TaskCategory> CONSOLE_TASK_CATEGORY_MANAGER = new ConsoleTaskCategoryManagerImpl();

    public AbstractMenu() {
    }

    public AbstractMenu(User user) {
        AbstractMenu.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        AbstractMenu.user = user;
    }

    public static Project getProject() {
        return project;
    }

    public static void setProject(Project project) {
        AbstractMenu.project = project;
    }

    public void setWorkingInThisMenu(boolean workingInThisMenu) {
        isWorkingInThisMenu = workingInThisMenu;
    }

    public void startMenu() {
        while (isWorkingInThisMenu) {
            menu = getMenuForUser(user);
            showMenu(menu);
            long menuItemToDo = selectItemFromMenu(menu);
            doMenuItemInMenu(menuItemToDo, menu);
        }
    }

    public long selectItemFromMenu(Map<Integer, String> menu) {
        return CONSOLE_OPERATION.getNumberFromTo(0, menu.size() - 1);
    }

    protected abstract Map<Integer, String> getMenuForUser(User user);

    public void showMenu(Map<Integer, String> menu) {
        menu.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    protected abstract void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu);

    public void printMenuTitle(String menuTitle) {
        System.out.println("**** " + menuTitle.toUpperCase() + " ****");
    }
}
