package services.impl;

import services.ConsoleOperationService;

import java.util.Scanner;

public class ConsoleOperationServiceImpl implements ConsoleOperationService {

    @Override
    public int getNumberFromTo(int from, int to) {
        Scanner scanner = new Scanner(System.in);

        int number;
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number < from || number > to) {
                    System.out.println("Please enter a number from " + from + " to " + to + "!");
                } else {
                    return number;
                }
            } else {
                System.out.println("You are entering letters!");
                scanner.next();
            }
        }
    }
}
