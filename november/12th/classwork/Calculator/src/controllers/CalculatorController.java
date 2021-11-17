package controllers;

import services.MenuService;
import services.MenuServiceImpl;

public class CalculatorController {
    private MenuService menuService = new MenuServiceImpl();

    public void start() {
        menuService.startMenu();
    }
}
