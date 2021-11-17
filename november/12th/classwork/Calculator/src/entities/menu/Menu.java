package entities.menu;

import java.util.Map;

public class Menu {
    private Map<Integer, String> menuItems;

    public Map<Integer, String> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Map<Integer, String> menuItems) {
        this.menuItems = menuItems;
    }
}
