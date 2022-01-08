package concole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleOperation {

    public long getNumberFromTo(long from, long to) {
        Scanner scanner = new Scanner(System.in);

        int number;
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number < from || number > to) {
                    System.out.println(ConsoleColors.RED + "Please enter a number from " + from + " to " + to + "!" +
                            ConsoleColors.RESET);
                } else {
                    return number;
                }
            } else {
                System.out.println(ConsoleColors.RED + "You are entering letters!" + ConsoleColors.RESET);
                scanner.next();
            }
        }
    }

    public String getStringLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        while (true) {
            try {
                string = reader.readLine();
                if (string != null && !string.isBlank()) {
                    return string;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
