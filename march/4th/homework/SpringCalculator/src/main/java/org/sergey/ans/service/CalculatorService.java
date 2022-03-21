package org.sergey.ans.service;

import org.sergey.ans.entity.CalculationResult;
import org.sergey.ans.entity.TwoVariableMathExpression;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculationResult calculate(TwoVariableMathExpression expression) {
        double result = expression.getOperation()
                .calculate(expression.getFirstValue(), expression.getSecondValue());
        return new CalculationResult(expression, result);
    }
}
