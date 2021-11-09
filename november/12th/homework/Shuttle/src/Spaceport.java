public class Spaceport{
    private static final int START_NUMBER = 10;

    public void launch(IStart iStart) {
        if (iStart.beforeStartSystemTest()) {
            iStart.engineStart();
            startCountdown();
            iStart.start();
        } else {
            System.out.println("Предстартовая проверка провалена");
        }
    }

    private void startCountdown() {
        int startCountdownNumber = START_NUMBER;
        while (startCountdownNumber >= 0) {
            System.out.println(startCountdownNumber);
            startCountdownNumber--;
        }
    }

}

