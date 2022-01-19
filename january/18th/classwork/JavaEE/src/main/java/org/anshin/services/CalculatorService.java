package org.anshin.services;

import java.util.List;

public interface CalculatorService<T> {

    T calculate(T firstValue, T secondValue, T operation);

    List<T> getCalculationHistory();
}
