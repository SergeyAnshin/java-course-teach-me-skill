public class SumOddNumbers {
    private int firstOddNumber;
    private int lastOddNumber;

    public SumOddNumbers(int firstOddNumber, int lastOddNumber) {
        this.firstOddNumber = firstOddNumber;
        this.lastOddNumber = lastOddNumber;
    }

    public int getSumOddNumbersUsingForLoop() {
        int sumOddNumbers = 0;
        for (int number = firstOddNumber; number <= lastOddNumber; number += 2) {
            sumOddNumbers += number;
        }
        return sumOddNumbers;
    }

    public int getSumOddNumbersUsingWhileLoop() {
        int sumOddNumbers = 0;
        int number = firstOddNumber;
        while (number <= lastOddNumber) {
            sumOddNumbers += number;
            number += 2;
        }
        return sumOddNumbers;
    }
}
