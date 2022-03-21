package org.sergey.ans.dao.impl.collectionstorage;

import org.sergey.ans.dao.CalculationResultDAO;
import org.sergey.ans.entity.CalculationResult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public final class CalculationResultListStorage implements CalculationResultDAO {
    private final List<CalculationResult> calculationResults = new ArrayList<>();

    @Override
    public boolean exists(CalculationResult calculationResult) {
        return calculationResults.contains(calculationResult);
    }

    @Override
    public boolean save(CalculationResult calculationResult) {
        return calculationResults.add(calculationResult);
    }

    @Override
    public List<CalculationResult> findAll() {
        return calculationResults;
    }
}
