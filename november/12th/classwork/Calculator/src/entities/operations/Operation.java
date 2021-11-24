package entities.operations;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Operation<T> {

    public T calculate(T firstValue, T secondValue, BinaryOperator<T> operator) {
        return operator.apply(firstValue, secondValue);
    }

    public T calculate(T value, UnaryOperator<T> operator) {
        return operator.apply(value);
    }
}
