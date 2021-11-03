public class Calculator {
    private int firstNumber;
    private int secondNumber;

    public Calculator() {
    }

    public Calculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int addNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int subtractNumbers(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiplyNumbers(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public int divideNumbers(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }



}
