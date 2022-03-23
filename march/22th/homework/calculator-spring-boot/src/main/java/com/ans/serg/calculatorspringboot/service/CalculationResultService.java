package com.ans.serg.calculatorspringboot.service;

import com.ans.serg.calculatorspringboot.dao.CalculationResultDAO;
import com.ans.serg.calculatorspringboot.entity.CalculationResult;
import com.ans.serg.calculatorspringboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationResultService {
    private CalculationResultDAO calculationResultDAO;

    public CalculationResultService(CalculationResultDAO calculationResultDAO) {
        this.calculationResultDAO = calculationResultDAO;
    }

    public boolean save(CalculationResult calculationResult) {
        if (calculationResultDAO.exists(calculationResult)) {
            return false;
        } else {
            return calculationResultDAO.save(calculationResult);
        }
    }

    public List<CalculationResult> findAllByUser(User user) {
        return calculationResultDAO.findAllByUser(user);
    }
}
