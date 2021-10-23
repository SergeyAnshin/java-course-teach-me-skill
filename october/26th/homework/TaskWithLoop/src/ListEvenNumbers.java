public class ListEvenNumbers {
    private int firstEvenNumber;
    private int lastEvenNumber;

    public ListEvenNumbers(int firstEvenNumber, int lastEvenNumber) {
        this.firstEvenNumber = firstEvenNumber;
        this.lastEvenNumber = lastEvenNumber;
    }

    public void printListEvenNumbersUsingForLoop() {
        System.out.println("For loop result: ");
        for (int number = firstEvenNumber; number <= lastEvenNumber; number += 2) {
            System.out.print(number + " ");
        }
    }

    public void printListEvenNumbersUsingWhileLoop() {
        System.out.println("While loop result: ");
        int number = firstEvenNumber;
        while (number <= lastEvenNumber) {
            System.out.print(number + " ");
            number += 2;
        }
    }
}
