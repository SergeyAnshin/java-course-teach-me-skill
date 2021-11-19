package controllers;

import services.MenuService;
import services.impl.MenuServiceImpl;

public class CalculatorController {
    private MenuService menuService = new MenuServiceImpl();

    public void start() {
        menuService.startMenu();
    }
}
