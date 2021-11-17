package entities.operations;

public class SimpleOperationImpl implements SimpleOperation<Double> {

    @Override
    public Double add(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public Double subtract(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public Double multiply(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public Double divide(Double firstNumber, Double secondNumber) {
        return firstNumber / secondNumber;
    }

    @Override
    public Double sin(Double number) {
        return Math.sin(number);
    }
}
