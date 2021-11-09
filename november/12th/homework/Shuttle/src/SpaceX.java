import java.util.Random;

public class SpaceX implements IStart {
    private static final int NUMBER_SUCCESSFUL_TEST = 5;

    @Override
    public boolean beforeStartSystemTest() {
        Random random = new Random();
        int randomNumber = random.nextInt(11);
        if (randomNumber > NUMBER_SUCCESSFUL_TEST) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void engineStart() {
        System.out.println("Двигатели SpaceX запущены. Все системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт SpaceX.");
    }
}
