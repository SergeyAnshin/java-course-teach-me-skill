package controllers;

import com.sun.tools.javac.Main;
import concole.ConsoleColors;
import concole.impl.ConsoleUserManagerImpl;
import entities.User;
import services.UserService;
import services.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MainMenu extends AbstractMenu {
    private ConsoleUserManagerImpl userManager = new ConsoleUserManagerImpl();
    private UserService<User> userService = new UserServiceImpl();
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

//    public MainMenu(User user) {
//        super(user);
//    }

    @Override
    public Map<Integer, String> getMenuForUser(User user) {
        System.out.println("**** MAIN MENU ****");
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
        System.out.println("**** LOG IN ****");
        String login = userManager.getStringValueForFieldFromConsole("login");
        String password = userManager.getStringValueForFieldFromConsole("password");
        User user = userService.findByLoginAndPassword(login, password);
        if (user != null) {
            setUser(user);
            user.setAuthorized(true);
        } else {
            System.out.println(ConsoleColors.RED + "User does not exist. Check username and password!"
                    + ConsoleColors.RESET);
        }
    }

    private void signIn() {
        System.out.println("**** REGISTRATION ****");
        userService.save(userManager.getEntity());
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
