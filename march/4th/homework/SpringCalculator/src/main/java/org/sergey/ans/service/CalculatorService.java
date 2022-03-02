package org.sergey.ans.service;

import org.sergey.ans.enums.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculate(double firstValue, double secondValue, String operation) {
        return Operation.valueOf(operation.trim().toUpperCase()).calculate(firstValue, secondValue);
    }
}
