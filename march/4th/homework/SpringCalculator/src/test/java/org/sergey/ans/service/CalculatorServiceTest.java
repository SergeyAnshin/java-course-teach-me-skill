package org.sergey.ans.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void calculate() {
        assertEquals(1.5, calculatorService.calculate(1, 0.5, "SUM"));
        assertEquals(1.5, calculatorService.calculate(3, 2, "DIVIDE"));
        assertEquals(1.5, calculatorService.calculate(2, 0.5, "SUBTRACT"));
        assertEquals(1.5, calculatorService.calculate(3, 0.5, "MULTIPLY"));
    }
}