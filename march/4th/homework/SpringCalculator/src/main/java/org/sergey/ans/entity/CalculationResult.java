package org.sergey.ans.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "calculation_result")
public class CalculationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expression_id", referencedColumnName = "id")
    private TwoVariableMathExpression expression;

    private double result;

    private final LocalDateTime creationDateTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public CalculationResult() {
    }

    public CalculationResult(TwoVariableMathExpression expression, double result) {
        this.expression = expression;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TwoVariableMathExpression getExpression() {
        return expression;
    }

    public void setExpression(TwoVariableMathExpression expression) {
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
        CalculationResult that = (CalculationResult) o;
        return Double.compare(that.result, result) == 0 && Objects.equals(expression, that.expression) && Objects.equals(creationDateTime, that.creationDateTime) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, result, creationDateTime, user);
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "id=" + id +
                ", expression=" + expression +
                ", result=" + result +
                ", creationDateTime=" + creationDateTime +
                ", user=" + user +
                '}';
    }
}
