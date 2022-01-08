package controllers;

import concole.ConsoleOperation;
import entities.User;

import java.util.Map;

public abstract class AbstractMenu {
    private static User user = new User();
    private Map<Integer, String> menu;
    private boolean isWorkingInThisMenu = true;
    public static final ConsoleOperation CONSOLE_OPERATION = new ConsoleOperation();

    public AbstractMenu() {
    }

    public AbstractMenu(User user) {
        AbstractMenu.user = user;
    }

    public void startMenu() {
        while (isWorkingInThisMenu) {
            menu = getMenuForUser(user);
            showMenu();
            long menuItemToDo = CONSOLE_OPERATION.getNumberFromTo(0, menu.size() - 1);
            doMenuItemInMenu(menuItemToDo, menu);
        }
    }

    protected abstract Map<Integer, String> getMenuForUser(User user);

    private void showMenu() {
        menu.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    protected abstract void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu);

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        AbstractMenu.user = user;
    }

    public void setWorkingInThisMenu(boolean workingInThisMenu) {
        isWorkingInThisMenu = workingInThisMenu;
    }


}
