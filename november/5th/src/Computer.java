import java.util.Random;
import java.util.Scanner;

public class Computer {
    private String processor;
    private String randomAccessMemory;
    private String hardDisk;
    private int maxNumberWorkCycles;
    private int currentNumberWorkingCycles = 0;
    private boolean isComputerTurnedOn = false;
    private boolean isComputerBurnedOut = false;
    private Scanner scanner;
    private Random random;
    private final int LOW_BOUND = 0;
    private final int HIGH_BOUND = 1;

    public Computer(String processor, String randomAccessMemory, String hardDisk, int maxNumberWorkCycles, Scanner scanner, Random random) {
        this.processor = processor;
        this.randomAccessMemory = randomAccessMemory;
        this.hardDisk = hardDisk;
        this.maxNumberWorkCycles = maxNumberWorkCycles;
        this.scanner = scanner;
        this.random = random;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public void setRandomAccessMemory(String randomAccessMemory) {
        this.randomAccessMemory = randomAccessMemory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public int getMaxNumberWorkCycles() {
        return maxNumberWorkCycles;
    }

    public void setMaxNumberWorkCycles(int maxNumberWorkCycles) {
        this.maxNumberWorkCycles = maxNumberWorkCycles;
    }

    public int getCurrentNumberWorkingCycles() {
        return currentNumberWorkingCycles;
    }

    public void setCurrentNumberWorkingCycles(int currentNumberWorkingCycles) {
        this.currentNumberWorkingCycles = currentNumberWorkingCycles;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean isBurnedOut() {
        return isComputerBurnedOut || haveReachedLimitWorkCycles();
    }

    private boolean haveReachedLimitWorkCycles() {
        return currentNumberWorkingCycles == maxNumberWorkCycles;
    }

    public void printComputerStatus() {
        if (isComputerTurnedOn) {
            System.out.println("Please turn off your computer");
        } else {
            System.out.println("Please turn on your computer");
        }
    }

    public void printInputMessage() {
        System.out.print("Enter the number between " + LOW_BOUND + " and " + HIGH_BOUND + " inclusive: ");
    }

    public void pressPowerButton() {
        printInputMessage();
        if (isRandomNumberEqualConsoleNumber()) {
            currentNumberWorkingCycles++;
            changePowerState();
        } else {
            isComputerBurnedOut = true;
        }
    }

    private void changePowerState() {
        isComputerTurnedOn = !isComputerTurnedOn;
    }

    private boolean isRandomNumberEqualConsoleNumber() {
        return getRandomNumber() == getNumberFromConsole();
    }

    private int getRandomNumber() {
        int randomNumber = random.nextInt(HIGH_BOUND + 1);
        return randomNumber;
    }

    private int getNumberFromConsole() {
        int number;
        do {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            number = scanner.nextInt();
        } while (!isNumberBetweenLowAndHighBounds(number));
        return number;
    }

    private boolean isNumberBetweenLowAndHighBounds(int number) {
        return number >= LOW_BOUND && number <= HIGH_BOUND;
    }

    public void printMessageAboutTheEnd(int computerNumber) {
        if (haveReachedLimitWorkCycles()) {
            System.out.println("I'm too old for this shit, goodbye!!! - computer " + computerNumber);
        } else {
            System.out.println("Leather motherfucker, you burned me!!! - computer " + computerNumber);
        }
        System.out.println();
    }

    public void printComputerDescription() {
        System.out.println("Computer{" +
                "processor='" + processor + '\'' +
                ", randomAccessMemory='" + randomAccessMemory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", maxNumberWorkCycles=" + maxNumberWorkCycles +
                '}');
    }
}
