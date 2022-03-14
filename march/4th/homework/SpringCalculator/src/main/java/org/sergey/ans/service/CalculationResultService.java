package org.sergey.ans.service;

import org.sergey.ans.dao.CalculationResultDAO;
import org.sergey.ans.entity.CalculationResult;
import org.sergey.ans.entity.TwoVariableMathExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationResultService {
    private final CalculationResultDAO calculationResultDAO;

    @Autowired
    public CalculationResultService(CalculationResultDAO calculationResultDAO) {
        this.calculationResultDAO = calculationResultDAO;
    }

    public boolean save(CalculationResult<TwoVariableMathExpression> calculationResult) {
        if (calculationResultDAO.exists(calculationResult)) {
            return false;
        } else {
            return calculationResultDAO.save(calculationResult);
        }
    }

    public List<CalculationResult<TwoVariableMathExpression>> findAll() {
        return calculationResultDAO.findAll();
    }
}
