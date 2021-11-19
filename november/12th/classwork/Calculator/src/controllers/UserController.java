package controllers;

import services.MenuService;
import services.impl.UserMenuImpl;

public class UserController {
    private MenuService menuService = new UserMenuImpl();

    public void start() {
        menuService.startMenu();
    }
}
