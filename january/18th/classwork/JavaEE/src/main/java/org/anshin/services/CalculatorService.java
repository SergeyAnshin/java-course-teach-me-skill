package org.anshin.services;

import org.anshin.entities.CalculationResult;

public interface CalculatorService<T> {

    CalculationResult<T> calculate(T firstValue, T secondValue, T operation);
}
