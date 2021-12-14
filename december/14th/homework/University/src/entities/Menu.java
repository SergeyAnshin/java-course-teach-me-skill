package entities;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, String> menu;

    public Menu() {
    }

    public Menu(Map<Integer, String> menu) {
        this.menu = menu;
    }

    public Map<Integer, String> getMenu() {
        return menu;
    }

    public void setMenu(Map<Integer, String> menu) {
        this.menu = menu;
    }
}
