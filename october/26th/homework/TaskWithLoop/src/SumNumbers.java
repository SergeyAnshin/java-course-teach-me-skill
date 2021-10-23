public class SumNumbers {
    private int firstNumber;
    private int lastNumber;
    private int stepMultiplier;

    {
        stepMultiplier = 2;
    }
    public SumNumbers(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
    }

    public int getSumNumbersUsingForLoop() {
        int sumNumbers = 0;
        for (int number = firstNumber; number <= lastNumber; number *= stepMultiplier) {
            sumNumbers += number;
        }
        return sumNumbers;
    }

    public int getSumNumbersUsingWhileLoop() {
        int sumNumbers = 0;
        int number = firstNumber;
        while (number <= lastNumber) {
            sumNumbers += number;
            number *= stepMultiplier;
        }
        return sumNumbers;
    }

    public int getSumNumbersUsingDoWhileLoop() {
        int sumNumbers = 0;
        int number = firstNumber;
        do {
            sumNumbers += number;
            number *= stepMultiplier;
        } while (number <= lastNumber);
        return sumNumbers;
    }

    public String printSumNumbers(int sumNumbers) {
        return "Sum of numbers = " + sumNumbers;
    }
}
