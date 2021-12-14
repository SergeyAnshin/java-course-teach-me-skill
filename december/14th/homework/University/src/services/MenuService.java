package services;

import entities.Menu;

import java.util.List;

public interface MenuService {

    void start();

    Menu create(List<String> menuItems);

    void show(Menu menu);

    void doMenuItemInMenu(int menuItem, Menu menu);
}
