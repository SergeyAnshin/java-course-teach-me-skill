package org.sergey.ans.entity;

import org.sergey.ans.enums.Operation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "math_expression")
public class TwoVariableMathExpression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private Double firstValue;

    @NotNull
    private Double secondValue;

    @NotNull
    private Operation operation;

    @OneToOne(mappedBy = "expression")
    private CalculationResult calculationResult;

    public TwoVariableMathExpression() {
    }

    public TwoVariableMathExpression(Double firstValue, Double secondValue, Operation operation) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public CalculationResult getCalculationResult() {
        return calculationResult;
    }

    public void setCalculationResult(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoVariableMathExpression that = (TwoVariableMathExpression) o;
        return id == that.id && Objects.equals(firstValue, that.firstValue) && Objects.equals(secondValue, that.secondValue) && operation == that.operation && Objects.equals(calculationResult, that.calculationResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstValue, secondValue, operation, calculationResult);
    }

    @Override
    public String toString() {
        return "TwoVariableMathExpression{" +
                "id=" + id +
                ", firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", operation=" + operation +
                ", calculationResult=" + calculationResult +
                '}';
    }
}
