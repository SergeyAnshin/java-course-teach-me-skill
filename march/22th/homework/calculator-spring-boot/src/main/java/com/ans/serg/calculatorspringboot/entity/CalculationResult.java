package com.ans.serg.calculatorspringboot.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CalculationResult extends Entity {
    private TwoVariableMathExpression expression;
    private double result;
    private User user;
}
