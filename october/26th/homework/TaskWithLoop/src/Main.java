public class Main {

    public static void main(String[] args) {
        String forLoop = "For loop result: ";
        String whileLoop = "While loop result: ";

        AthleteWorkout athleteWorkout = new AthleteWorkout(10, 20, 8);
        float totalDistanceUsingForLoop = athleteWorkout.getTotalDistanceUsingForLoop();
        float totalDistanceUsingWhileLoop = athleteWorkout.getTotalDistanceUsingWhileLoop();
        System.out.println(forLoop + athleteWorkout.printTotalDistance(totalDistanceUsingForLoop));
        System.out.println(whileLoop + athleteWorkout.printTotalDistance(totalDistanceUsingWhileLoop));

        System.out.println();

        AmoebaDivision amoebaDivision = new AmoebaDivision(1, 3, 24, 2);
        amoebaDivision.getNumberAmoebasByDivisionPeriodsUsingForLoop();
        amoebaDivision.getNumberAmoebasByDivisionPeriodsUsingWhileLoop();

        System.out.println();

        SumNumbers sumNumbers = new SumNumbers(1, 256, 2);
        int sumUsingForLoop = sumNumbers.getSumNumbersUsingForLoop();
        int sumUsingWhileLoop = sumNumbers.getSumNumbersUsingWhileLoop();
        System.out.println(forLoop + sumNumbers.printSumNumbers(sumUsingForLoop));
        System.out.println(whileLoop + sumNumbers.printSumNumbers(sumUsingWhileLoop));

        System.out.println();

        NumberMultiplication numberMultiplication = new NumberMultiplication(3, 5);
        System.out.println(forLoop + numberMultiplication.getProductNumbersUsingForLoop());
        System.out.println(whileLoop + numberMultiplication.getProductNumbersUsingWhileLoop());

        System.out.println();

        ConversionTable conversionTable = new ConversionTable(1, 20);
        conversionTable.printTableForConvertingInchesToCentimetersUsingForLoop();
        conversionTable.printTableForConvertingInchesToCentimetersUsingWhileLoop();

        System.out.println();

        ListEvenNumbers listEvenNumbers = new ListEvenNumbers(2, 100);
        listEvenNumbers.printListEvenNumbersUsingForLoop();
        System.out.println();
        listEvenNumbers.printListEvenNumbersUsingWhileLoop();
        System.out.println();

        System.out.println();

        SumOddNumbers sumOddNumbers = new SumOddNumbers(1, 99);
        System.out.println(forLoop + sumOddNumbers.getSumOddNumbersUsingForLoop());
        System.out.println(whileLoop + sumOddNumbers.getSumOddNumbersUsingWhileLoop());
    }
}
