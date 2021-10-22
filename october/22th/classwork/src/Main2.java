public class Main2 {

    public static void main(String[] args) {
        int sportsmenDistanceFirstDay = 10;
        float sportsmenTotalDistance = sportsmenDistanceFirstDay;
        for (int raceDuration = 2; raceDuration <= 7; raceDuration++) {
            sportsmenTotalDistance *= 1.1;
        }
        System.out.println("Total distance of sportsmen = " + sportsmenTotalDistance);

        System.out.println("__________");

        int cellNumber = 1;
        for (int splitTime = 3; splitTime <= 24; splitTime += 3) {
            cellNumber *= 2;
            System.out.println("Time of split = " + splitTime + ", Number of cell = " + cellNumber);
        }

        System.out.println("__________");

        int sumNumbers = 0;
        for (int i = 1; i <= 256; i *= 2) {
            sumNumbers += i;
        }
        System.out.println("Sum of numbers 1, 2, 4 ... = " + sumNumbers);

        System.out.println("__________");

        int A = 3;
        int B = 5;
        int multiplication = 0;
        for (int i = 0; i < B; i++) {
            multiplication += A;
        }
        System.out.println("A * B = " + multiplication);

        System.out.println("__________");

        int distanceValue = 1;
        System.out.println("Number of inch, Number of centimetre");
        while (distanceValue < 21) {
            System.out.println(" " + distanceValue + " " + (distanceValue * 2.54));
            distanceValue++;
        }

        System.out.println("__________");

        for (int i = 2; i <= 100 ; i += 2) {
            System.out.print(i + " ");
        }

        System.out.println("");
        System.out.println("__________");

        int numberSum = 0;
        for (int i = 1; i < 100; i += 2) {
            numberSum += i;
        }
        System.out.println(numberSum);
    }
}
