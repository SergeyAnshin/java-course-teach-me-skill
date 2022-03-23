package com.ans.serg.calculatorspringboot.entity;

import com.ans.serg.calculatorspringboot.enums.Operation;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TwoVariableMathExpression extends Entity {
    private Double firstValue;
    private Double secondValue;
    private Operation operation;
    private CalculationResult calculationResult;
}
