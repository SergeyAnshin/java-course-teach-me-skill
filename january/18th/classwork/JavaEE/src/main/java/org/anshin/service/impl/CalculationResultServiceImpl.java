package org.anshin.service.impl;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;
import org.anshin.repository.CalculationResultRepository;
import org.anshin.repository.impl.CalculationResultHashMapRepository;
import org.anshin.service.CalculationResultService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CalculationResultServiceImpl implements CalculationResultService<CalculationResult> {
    private final CalculationResultRepository<CalculationResult> resultRepository =
            new CalculationResultHashMapRepository();

    @Override
    public boolean save(CalculationResult calculationResult) {
        return resultRepository.save(calculationResult);
    }

    @Override
    public List<CalculationResult> findAllByUser(User user) {
        List<CalculationResult> calculationResults = resultRepository.findAllByUser(user);
        return Objects.requireNonNullElse(calculationResults, Collections.emptyList());
    }

    @Override
    public List<CalculationResult> findAll() {
        return resultRepository.findAll();
    }

}
