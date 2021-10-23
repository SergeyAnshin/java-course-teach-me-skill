public class SumOddNumbers {
    private int firstNumber;
    private int lastNumber;
    private final int STEP = 2;

    public SumOddNumbers(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
    }

    public int getSumOddNumbersUsingForLoop() {
        int sumOddNumbers = 0;
        for (int number = firstNumber; number <= lastNumber; number += STEP) {
            sumOddNumbers += number;
        }
        return sumOddNumbers;
    }

    public int getSumOddNumbersUsingWhileLoop() {
        int sumOddNumbers = 0;
        int number = getFirstOddNumber(firstNumber);
        while (number <= lastNumber) {
            sumOddNumbers += number;
            number += STEP;
        }
        return sumOddNumbers;
    }

    public int getSumOddNumbersUsingDoWhileLoop() {
        int sumOddNumbers = 0;
        int number = getFirstOddNumber(firstNumber);
        do {
            sumOddNumbers += number;
            number += STEP;
        } while (number <= lastNumber);
        return sumOddNumbers;
    }

    private int getFirstOddNumber(int firstNumber) {
        return firstNumber % 2 != 0 ? firstNumber : firstNumber + 1;
    }
}
