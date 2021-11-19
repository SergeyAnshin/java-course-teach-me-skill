package services.impl;

import entities.menu.Menu;
import services.CalculatorService;
import services.MenuService;
import services.StorageService;

import java.util.HashMap;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {
    private Menu menu = new Menu();
    private StorageService storageService = new StorageServiceImpl();
    private CalculatorService calculatorService = new CalculatorServiceImpl(storageService);

    @Override
    public void startMenu() {
        displayGreeting();
        createMenu();
        showMenu();
        performAction();
    }

    public void displayGreeting() {
        System.out.println("Hello user");
    }

    @Override
    public void createMenu() {
        HashMap<Integer, String> menuItem = new HashMap<>();
        menuItem.put(0, "Calculator");
        menuItem.put(1, "History");
        menuItem.put(2, "Exit");
        menu.setMenuItems(menuItem);
    }

    @Override
    public void showMenu() {
        menu.getMenuItems()
                .forEach((key, value) -> System.out.println(key + " - " + value));
    }

    @Override
    public void performAction() {
        int actionNumber = getActionNumber();
        if (actionNumber == 0) {
            calculatorService.calculateExpression();
            showMenu();
            performAction();
        } else if (actionNumber == 1) {
            System.out.println(storageService.getAllStorage());
            showMenu();
            performAction();
        } else {
            System.exit(0);
        }
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
}
