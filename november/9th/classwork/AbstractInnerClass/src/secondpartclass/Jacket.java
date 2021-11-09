package secondpartclass;

import java.util.Random;
import java.util.Scanner;

public class Jacket extends Clothes {
    private static final String PUT_ON_MESSAGE = "Jacket is on";
    private static final String TAKE_OFF_MESSAGE = "Jacket off";
    private static final String PUT_ON_MESSAGE_ERROR = "Jacket could not be put on";
    private static final String TAKE_OFF_MESSAGE_ERROR = "Jacket could not be take off";
    private static final String PUT_ON_GREETINGS = "Try to pun on a jacket";
    private static final String TAKE_OFF_GREETINGS = "Try to take off a jacket";

    public Jacket(boolean isPutOn) {
        super(isPutOn);
    }

    @Override
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(2);
    }

    @Override
    public int getConsoleNumber() {
        Scanner scanner = new Scanner(System.in);
        int consoleNumber = -1;
        do {
            System.out.println("Enter integer number between 0 and 1");
            if (scanner.hasNextInt()) {
                consoleNumber = scanner.nextInt();
            } else {
                scanner.next();
            }
        } while (consoleNumber < 0 || consoleNumber > 1);
        return consoleNumber;
    }

    @Override
    public void putClothesOn() {
        System.out.println(PUT_ON_GREETINGS);
        if (getRandomNumber() == getConsoleNumber()) {
            System.out.println(PUT_ON_MESSAGE);
            setPutOn(true);
        } else {
            System.out.println(PUT_ON_MESSAGE_ERROR);
            setPutOn(false);
        }
    }

    @Override
    public void takeOffClothes() {
        System.out.println(TAKE_OFF_GREETINGS);
        if (getRandomNumber() == getConsoleNumber()) {
            System.out.println(TAKE_OFF_MESSAGE);
            setPutOn(false);
        } else {
            System.out.println(TAKE_OFF_MESSAGE_ERROR);
            setPutOn(true);
        }
    }
}
