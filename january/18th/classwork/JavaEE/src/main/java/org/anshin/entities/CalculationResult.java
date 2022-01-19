package org.anshin.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class CalculationResult<T> {
    private T result;
    private LocalDateTime calculationTime = LocalDateTime.now();

    public CalculationResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public LocalDateTime getCalculationTime() {
        return calculationTime;
    }

    public void setCalculationTime(LocalDateTime calculationTime) {
        this.calculationTime = calculationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResult<?> that = (CalculationResult<?>) o;
        return calculationTime.equals(that.calculationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculationTime);
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "result=" + result +
                ", calculationTime=" + calculationTime +
                '}';
    }
}
