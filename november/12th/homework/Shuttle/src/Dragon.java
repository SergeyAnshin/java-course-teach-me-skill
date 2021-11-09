import java.util.Random;

public class Dragon implements IStart {
    private static final int NUMBER_SUCCESSFUL_TEST = 8;

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
        System.out.println("Двигатели Dragon запущены. Все системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт Dragon.");
    }
}
