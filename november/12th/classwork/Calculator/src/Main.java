
import controllers.CalculatorController;
import controllers.UserController;

public class Main {
    public static void main(String[] args) {

        UserController userController = new UserController();
        userController.start();
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.start();

    }
}
