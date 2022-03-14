package org.sergey.ans.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class CalculationResult<Exp> {
    private Exp expression;
    private double result;
    private final LocalDateTime creationDateTime = LocalDateTime.now();
    private User user;

    public CalculationResult(Exp expression, double result) {
        this.expression = expression;
        this.result = result;
    }

    public Exp getExpression() {
        return expression;
    }

    public void setExpression(Exp expression) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
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
        return Double.compare(that.result, result) == 0 && Objects.equals(expression, that.expression) && Objects.equals(creationDateTime, that.creationDateTime) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, result, creationDateTime, user);
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "expression=" + expression +
                ", result=" + result +
                ", creationDateTime=" + creationDateTime +
                ", user=" + user +
                '}';
    }
}
