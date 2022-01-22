package org.anshin.services.impl;

import org.anshin.entities.CalculationResult;
import org.anshin.enums.Operation;
import org.anshin.services.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService<String> {

    @Override
    public CalculationResult<String> calculate(String firstValue, String secondValue, String operation) {
        Double result = Operation.valueOf(operation.toUpperCase())
                .calculate(Double.parseDouble(firstValue), Double.parseDouble(secondValue));
        return new CalculationResult<>(String.valueOf(result), Operation.valueOf(operation.toUpperCase()));
    }
}
