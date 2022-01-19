package org.anshin.repositories.impl;

import org.anshin.entities.CalculationResult;
import org.anshin.repositories.CalculatorRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculatorRepositoryImpl implements CalculatorRepository<CalculationResult<String>> {
    private List<CalculationResult<String>> calculationResultStorage = new ArrayList<>();

    @Override
    public boolean save(CalculationResult<String> calculationResult) {
        return calculationResultStorage.add(calculationResult);
    }

    @Override
    public List<CalculationResult<String>> findAll() {
        return calculationResultStorage;
    }
}
