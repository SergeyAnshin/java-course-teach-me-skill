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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoVariableMathExpression that = (TwoVariableMathExpression) o;
        return Objects.equals(firstValue, that.firstValue) && Objects.equals(secondValue, that.secondValue) && operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue, operation);
    }

    @Override
    public String toString() {
        return "TwoVariableMathExpression{" +
                "firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", operation=" + operation +
                '}';
    }
}
