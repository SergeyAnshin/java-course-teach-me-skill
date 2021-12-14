import services.MenuService;
import services.impl.MenuServiceImp;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuServiceImp();
        menuService.start();
    }
}
