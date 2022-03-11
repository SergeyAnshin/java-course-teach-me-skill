package org.sergey.ans.entity;

import org.sergey.ans.enums.Operation;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TwoVariableMathExpression {

    @NotNull
    private Double firstValue;

    @NotNull
    private Double secondValue;

    @NotNull
    private Operation operation;

    private Double result;

    public TwoVariableMathExpression(Double firstValue, Double secondValue, Operation operation) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
    }

    public Double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Double firstValue) {
        this.firstValue = firstValue;
    }

    public Double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Double secondValue) {
        this.secondValue = secondValue;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoVariableMathExpression that = (TwoVariableMathExpression) o;
        return Objects.equals(firstValue, that.firstValue) && Objects.equals(secondValue, that.secondValue) && operation == that.operation && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue, operation, result);
    }

    @Override
    public String toString() {
        return "MathExpression{" +
                "firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", operation=" + operation +
                ", result=" + result +
                '}';
    }
}
