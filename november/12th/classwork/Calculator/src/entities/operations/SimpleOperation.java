package entities.operations;

public interface SimpleOperation<T> {

    T add(T firstNumber, T secondNumber);

    T subtract(T firstNumber, T secondNumber);

    T multiply(T firstNumber, T secondNumber);

    T divide(T firstNumber, T secondNumber);

    T sin(T number);
}
