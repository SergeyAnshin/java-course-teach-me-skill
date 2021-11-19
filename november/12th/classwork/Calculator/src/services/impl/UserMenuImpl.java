package services.impl;

import entities.menu.Menu;
import services.MenuService;
import services.StorageService;
import services.UserService;

import java.util.HashMap;
import java.util.Scanner;

public class UserMenuImpl implements MenuService {
    private Menu menu = new Menu();
    private StorageService storageService = new UserStorageImpl();
    private UserService userService = new UserServiceImpl(storageService);

    @Override
    public void startMenu() {
        createMenu();
        showMenu();
        performAction();
    }

    @Override
    public void createMenu() {
        HashMap<Integer, String> menuItem = new HashMap<>();
        menuItem.put(0, "Sign up");
        menuItem.put(1, "Login");
        menu.setMenuItems(menuItem);
    }

    @Override
    public void showMenu() {
        menu.getMenuItems().forEach((key, value) -> System.out.println(key + " - " + value));
    }

    @Override
    public int getActionNumber() {
        Scanner scanner = new Scanner(System.in);

        int actionNumber;
        while (true) {
            System.out.print("Select the menu item: ");
            if (scanner.hasNextInt()) {
                actionNumber = scanner.nextInt();
                if (actionNumber < 0 || actionNumber > menu.getMenuItems().size() - 1) {
                    System.out.println("Please enter a number from 0 to " + (menu.getMenuItems().size() - 1));
                } else {
                    return actionNumber;
                }
            } else {
                System.out.println("You are entering letters. " + "Please enter a number from 0 to " +
                        (menu.getMenuItems().size() - 1));
                scanner.next();
            }
        }
    }

    @Override
    public void performAction() {
        int actionNumber = getActionNumber();
        if (actionNumber == 0) {
            userService.signUp();
            showMenu();
            performAction();
        } else if (actionNumber == 1) {
            boolean isLogin = userService.login();
            if (isLogin) {
                System.out.println("Incorrect login or password");
                showMenu();
                performAction();
            }
        } else {
            System.exit(0);
        }
    }

}
