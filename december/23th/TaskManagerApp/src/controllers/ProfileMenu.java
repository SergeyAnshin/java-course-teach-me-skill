package controllers;

import com.sun.tools.javac.Main;
import concole.ConsoleEntityManager;
import concole.impl.ConsoleUserManagerImpl;
import entities.Project;
import entities.User;
import services.ProjectService;
import services.UserService;
import services.impl.ProjectServiceImpl;
import services.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ProfileMenu extends AbstractMenu {
    private User newUser;
    private ConsoleEntityManager<User> userManager = new ConsoleUserManagerImpl();
    private UserService<User> userService = new UserServiceImpl();
    private ProjectService<Project> projectService = new ProjectServiceImpl();
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
        System.out.println("**** ACCOUNT ****");
        System.out.println(newUser);
        return profileMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            String login = userManager.getStringValueForFieldFromConsole("login");
            newUser.setLogin(login);
        } else if (menuItemToDo == 1) {
            String email = userManager.getStringValueForFieldFromConsole("email");
            newUser.setEmail(email);
        } else if (menuItemToDo == 2) {
            String password = userManager.getStringValueForFieldFromConsole("password");
            newUser.setPassword(password);
        } else if (menuItemToDo == 3) {
            userService.update(newUser);
        } else if (menuItemToDo == 4) {
            userService.delete(getUser());
            setUser(new User());
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 5) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 6) {
            System.exit(0);
        }
    }
}
