package org.anshin.service;

import org.anshin.entity.CalculationResult;

public interface CalculatorService<T, O> {

    CalculationResult calculate(T firstValue, T secondValue, O operation);
}
