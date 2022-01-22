package org.anshin.services.impl;

import org.anshin.entities.CalculationResult;
import org.anshin.entities.User;
import org.anshin.enums.Operation;
import org.anshin.repositories.CalculationResultRepository;
import org.anshin.repositories.impl.CalculationResultRepositoryImpl;
import org.anshin.services.CalculationResultService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CalculationResultServiceImpl implements CalculationResultService<CalculationResult<String>> {
    private final CalculationResultRepository<CalculationResult<String>> resultRepository =
            new CalculationResultRepositoryImpl();

    @Override
    public boolean save(CalculationResult<String> calculationResult) {
        return resultRepository.save(calculationResult);
    }

    @Override
    public List<CalculationResult<String>> findAllByUser(User user) {
        List<CalculationResult<String>> calculationResults = resultRepository.findAllByUser(user);
        return Objects.requireNonNullElse(calculationResults, Collections.emptyList());
    }

    @Override
    public List<CalculationResult<String>> findAll() {
        return resultRepository.findAll();
    }
}
