package org.anshin.service.impl;

import org.anshin.entity.CalculationResult;
import org.anshin.enums.Operation;
import org.anshin.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService<Double, Operation> {

    @Override
    public CalculationResult calculate(Double firstValue, Double secondValue, Operation operation) {
        double result = operation.calculate(firstValue, secondValue);
        return new CalculationResult(firstValue, secondValue, operation, result);
    }
}
