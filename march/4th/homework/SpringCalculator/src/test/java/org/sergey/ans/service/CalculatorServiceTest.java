package org.sergey.ans.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sergey.ans.entity.TwoVariableMathExpression;
import org.sergey.ans.enums.Operation;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    private static TwoVariableMathExpression expression;
    private static TwoVariableMathExpression expression1;
    private static TwoVariableMathExpression expression2;
    private static TwoVariableMathExpression expression3;

    @BeforeAll
    static void init() {
        expression = new TwoVariableMathExpression(1D, 0.5, Operation.SUM);
        expression1 = new TwoVariableMathExpression(3D, 2D, Operation.DIVIDE);
        expression2 = new TwoVariableMathExpression(2D, 0.5, Operation.SUBTRACT);
        expression3 = new TwoVariableMathExpression(3D, 0.5, Operation.MULTIPLY);
    }

    @Test
    void calculate() {
        assertEquals(1.5, calculatorService.calculate(expression).getResult());
        assertEquals(1.5, calculatorService.calculate(expression1).getResult());
        assertEquals(1.5, calculatorService.calculate(expression2).getResult());
        assertEquals(1.5, calculatorService.calculate(expression3).getResult());
    }
}