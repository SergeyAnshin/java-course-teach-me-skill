package org.sergey.ans.dao.impl.collectionstorage;

import org.sergey.ans.dao.CalculationResultDAO;
import org.sergey.ans.entity.CalculationResult;
import org.sergey.ans.entity.TwoVariableMathExpression;
import org.sergey.ans.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public final class CalculationResultListStorage implements CalculationResultDAO {
    private final List<CalculationResult<TwoVariableMathExpression>> calculationResults = new ArrayList<>();


    @Override
    public boolean exists(CalculationResult<TwoVariableMathExpression> calculationResult) {
        return calculationResults.contains(calculationResult);
    }

    @Override
    public boolean save(CalculationResult<TwoVariableMathExpression> calculationResult) {
        return calculationResults.add(calculationResult);
    }

    @Override
    public List<CalculationResult<TwoVariableMathExpression>> findAll() {
        return calculationResults;
    }
}
