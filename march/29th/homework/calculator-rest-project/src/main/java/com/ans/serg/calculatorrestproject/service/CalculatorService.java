package com.ans.serg.calculatorrestproject.service;

import com.ans.serg.calculatorrestproject.entity.CalculationResult;
import com.ans.serg.calculatorrestproject.entity.TwoVariableMathExpression;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculationResult calculate(TwoVariableMathExpression expression) {
        double result = expression.getOperation()
                .calculate(expression.getFirstValue(), expression.getSecondValue());
        return CalculationResult.builder()
                .expression(expression)
                .result(result)
                .build();
    }
}
