package controllers;

import entities.User;

import java.util.HashMap;
import java.util.Map;

public class MainMenu extends AbstractMenu {
    private Map<Integer, String> unauthorizedUserMenu = new HashMap<>() {{
        put(0, "Sign Up");
        put(1, "Log in");
        put(2, "Exit");
    }};
    private Map<Integer, String> authorizedUserMenu = new HashMap<>() {{
        put(0, "Sign Up");
        put(1, "Log in");
        put(2, "Profile");
        put(3, "Projects");
        put(4, "Exit");
    }};

    @Override
    public Map<Integer, String> getMenuForUser(User user) {
        printMenuTitle("main menu");
        return user != null && user.isAuthorized() ? authorizedUserMenu : unauthorizedUserMenu;
    }

    @Override
    public void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (getUser().isAuthorized()) {
            doMenuItemInAuthorizedMenu(menuItemToDo);
        } else {
            doMenuItemInUnauthorizedMenu(menuItemToDo);
        }
    }

    private void doMenuItemInAuthorizedMenu(long menuItemToDo) {
        if (menuItemToDo == 0) {
            signIn();
        } else if (menuItemToDo == 1) {
            logIn();
        } else if (menuItemToDo == 2) {
            goIntoProfileMenu();
        } else if (menuItemToDo == 3) {
            goIntoProjectMainMenu();
        } else if (menuItemToDo == 4) {
            System.exit(0);
        }
    }

    private void doMenuItemInUnauthorizedMenu(long menuItemToDo) {
        if (menuItemToDo == 0) {
            signIn();
        } else if (menuItemToDo == 1) {
            logIn();
        } else if (menuItemToDo == 2) {
            System.exit(0);
        }
    }

    private void logIn() {
        printMenuTitle("log in");
        String login = CONSOLE_USER_MANAGER.getStringValueForFieldFromConsole("login");
        String password = CONSOLE_USER_MANAGER.getStringValueForFieldFromConsole("password");
        User user = USER_SERVICE.findByLoginAndPassword(login, password);
        if (user != null) {
            setUser(user);
            user.setAuthorized(true);
        }
    }

    private void signIn() {
        printMenuTitle("registration");
        USER_SERVICE.save(CONSOLE_USER_MANAGER.getEntity());
        if (getUser().isAuthorized()) {
            setUser(new User());
        }

    }

    private void goIntoProfileMenu() {
        ProfileMenu profileMenu = new ProfileMenu();
        profileMenu.startMenu();
    }

    private void goIntoProjectMainMenu() {
        ProjectMainMenu projectMainMenu = new ProjectMainMenu();
        projectMainMenu.startMenu();
    }
}
