package controllers;

import entities.User;

import java.util.HashMap;
import java.util.Map;

public class ProfileMenu extends AbstractMenu {
    private User newUser;
    private Map<Integer, String> profileMenu = new HashMap<>() {{
        put(0, "Edit login");
        put(1, "Edit email");
        put(2, "Edit password");
        put(3, "Save changes");
        put(4, "Delete account");
        put(5, "Main menu");
        put(6, "Exit");
    }};

    public ProfileMenu() {
        this.newUser = new User(getUser());
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        printMenuTitle("account");
        System.out.println(newUser);
        return profileMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            printMenuTitle("edit login");
            String login = CONSOLE_USER_MANAGER.getStringValueForFieldFromConsole("login");
            newUser.setLogin(login);
        } else if (menuItemToDo == 1) {
            printMenuTitle("edit email");
            String email = CONSOLE_USER_MANAGER.getStringValueForFieldFromConsole("email");
            newUser.setEmail(email);
        } else if (menuItemToDo == 2) {
            printMenuTitle("edit password");
            String password = CONSOLE_USER_MANAGER.getStringValueForFieldFromConsole("password");
            newUser.setPassword(password);
        } else if (menuItemToDo == 3) {
            USER_SERVICE.update(newUser);
        } else if (menuItemToDo == 4) {
            USER_SERVICE.delete(getUser());
            setUser(new User());
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 5) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 6) {
            System.exit(0);
        }
    }
}
