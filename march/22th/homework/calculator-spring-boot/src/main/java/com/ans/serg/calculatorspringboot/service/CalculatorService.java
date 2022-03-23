package com.ans.serg.calculatorspringboot.service;

import com.ans.serg.calculatorspringboot.entity.CalculationResult;
import com.ans.serg.calculatorspringboot.entity.TwoVariableMathExpression;
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
