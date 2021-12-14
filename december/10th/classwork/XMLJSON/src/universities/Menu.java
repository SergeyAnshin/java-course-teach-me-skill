package universities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private HashMap<String, String> menu = new HashMap<>();
    private HashMap<String, String> sortMenu = new HashMap<>();
    private HashMap<String, String> menuEntities = new HashMap<>();

    public void start() {
        createMenu();
        createSortMenu();
        createMenuEntities();
        while (true) {
            showMenu(menu);
            performAction();
        }
    }

    private void createMenu() {
        menu.put("0", "Add some entities");
        menu.put("1", "Get average rating");
        menu.put("2", "Show some entities");
        menu.put("4", "Exit");
    }

    private void createMenuEntities() {
        menuEntities.put("0", "Group");
    }

    private void createSortMenu() {
        sortMenu.put("0", "Sort by average rating");
    }

    private void showMenu(Map<String, String> menu) {
        menu.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    private void performAction() {
        int actionNumberFromMenu = getActionNumber(menu);
        if (actionNumberFromMenu == 0) {

        } else if (actionNumberFromMenu == 1) {

        } else if (actionNumberFromMenu == 2) {
            showMenu(menuEntities);
            int actionNumberFromMenuEntities = getActionNumber(menuEntities);
            if (actionNumberFromMenuEntities == 0) {
                showMenu(sortMenu);

            }
            getActionNumber(sortMenu);
        } else if (actionNumberFromMenu == 3) {

        } else if (actionNumberFromMenu == 4) {
            System.exit(0);
        }
    }

    private int getActionNumber(Map<String,String> menu) {
        Scanner scanner = new Scanner(System.in);

        int actionNumber;
        while (true) {
            System.out.print("Select the menu item: ");
            if (scanner.hasNextInt()) {
                actionNumber = scanner.nextInt();
                if (actionNumber < 0 || actionNumber > menu.size() - 1) {
                    System.out.println("Please enter a number from 0 to " + (menu.size() - 1));
                } else {
                    return actionNumber;
                }
            } else {
                System.out.println("You are entering letters. " + "Please enter a number from 0 to " +
                        (menu.size() - 1));
                scanner.next();
            }
        }
    }
}
