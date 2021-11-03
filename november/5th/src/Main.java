import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Computer computer = new Computer("proc", "mem", "disk",
                3, scanner, random);

        int computerCounter = 0;
        while (true) {
            if (!computer.isBurnedOut()) {
                computer.printComputerStatus();
                computer.pressPowerButton();
            } else {
                computer.printMessageAboutTheEnd(computerCounter);
                computer = new Computer("proc", "mem", "disk",
                        3, scanner, random);
                computerCounter++;
            }
        }
    }
}
