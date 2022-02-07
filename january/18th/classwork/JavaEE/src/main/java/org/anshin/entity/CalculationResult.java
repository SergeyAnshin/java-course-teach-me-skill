package org.anshin.entity;

import org.anshin.enums.Operation;

import java.time.LocalDateTime;
import java.util.Objects;

public class CalculationResult extends Entity {
    private Long id;
    private double firstValue;
    private double secondValue;
    private Operation operation;
    private double result;
    private LocalDateTime calculationTime = LocalDateTime.now();
    private User user;

    public CalculationResult() {
    }

    public CalculationResult(Operation operation, double result) {
        this.operation = operation;
        this.result = result;
    }

    public CalculationResult(double firstValue, double secondValue, Operation operation, double result) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public LocalDateTime getCalculationTime() {
        return calculationTime;
    }

    public void setCalculationTime(LocalDateTime calculationTime) {
        this.calculationTime = calculationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResult that = (CalculationResult) o;
        return calculationTime.equals(that.calculationTime) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculationTime, user);
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "id=" + id +
                ", firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", operation=" + operation +
                ", result=" + result +
                ", calculationTime=" + calculationTime +
                ", user=" + user +
                '}';
    }
}
