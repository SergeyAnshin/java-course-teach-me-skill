package org.anshin.entities;

import org.anshin.enums.Operation;

import java.time.LocalDateTime;
import java.util.Objects;

public class CalculationResult< T> {
    private T result;
    private Operation operation;
    private LocalDateTime calculationTime = LocalDateTime.now();
    private User user;

    public CalculationResult(T result, Operation operation) {
        this.result = result;
        this.operation = operation;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
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
        CalculationResult<?> that = (CalculationResult<?>) o;
        return calculationTime.equals(that.calculationTime) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculationTime, user);
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "result=" + result +
                ", operation=" + operation +
                ", calculationTime=" + calculationTime +
                ", user=" + user +
                '}';
    }
}
