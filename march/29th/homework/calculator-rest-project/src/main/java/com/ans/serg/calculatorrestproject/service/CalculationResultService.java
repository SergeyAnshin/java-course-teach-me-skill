package com.ans.serg.calculatorrestproject.service;

import com.ans.serg.calculatorrestproject.entity.CalculationResult;
import com.ans.serg.calculatorrestproject.entity.User;
import com.ans.serg.calculatorrestproject.repository.CalculationResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationResultService {
    private CalculationResultRepository calculationResultRepository;

    public CalculationResultService(CalculationResultRepository calculationResultRepository) {
        this.calculationResultRepository = calculationResultRepository;
    }

    public CalculationResult save(CalculationResult calculationResult) {
        return calculationResultRepository.save(calculationResult);
    }

    public List<CalculationResult> findAllByUserId(long id) {
        return calculationResultRepository.findAllByUserId(id);
    }
}
