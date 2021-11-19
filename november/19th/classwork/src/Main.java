import exceptions.MarkNotSuitable;
import exceptions.PriceNotSuitable;
import exceptions.SpeedNotSuitable;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user = new User("Tom", 600d, 200d, Set.of("BMW", "VOLVO", "RENAULT"));
        Car car = new Car(600, 200d, "SKODA", user);

        try {
            car.isMarkSuitableForBuyer();
            car.isPriceSuitableForBuyer();
            car.isMaxSpeedSuitableForBuyer();
        } catch (MarkNotSuitable | PriceNotSuitable | SpeedNotSuitable exception) {
            exception.printStackTrace();
        }


    }
}
