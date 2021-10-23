public class ListEvenNumbers {
    private int firstNumber;
    private int lastNumber;
    private final int STEP = 2;

    public ListEvenNumbers(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
    }

    public void printListEvenNumbersUsingForLoop() {
        System.out.println("For loop result: ");
        for (int number = getFirstEvenNumber(firstNumber); number <= lastNumber; number += STEP) {
            System.out.print(number + " ");
        }
    }

    public void printListEvenNumbersUsingWhileLoop() {
        System.out.println("While loop result: ");
        int number = getFirstEvenNumber(firstNumber);
        while (number <= lastNumber) {
            System.out.print(number + " ");
            number += STEP;
        }
    }

    public void printListEvenNumbersUsingDoWhileLoop() {
        System.out.println("DoWhile loop result: ");
        int number = getFirstEvenNumber(firstNumber);
        do {
            System.out.print(number + " ");
            number += STEP;
        } while (number <= lastNumber);
    }

    private int getFirstEvenNumber(int firstNumber) {
        return firstNumber % 2 == 0 ? firstNumber : firstNumber + 1;
    }
}
