package org.anshin.service.impl;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.dao.CalculationResultDAO;
import org.anshin.service.CalculationResultService;

import java.util.List;

public class CalculationResultServiceImpl implements CalculationResultService {
    private final CalculationResultDAO resultRepository;

    public CalculationResultServiceImpl(CalculationResultDAO resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public boolean save(CalculationResult calculationResult) {
        return resultRepository.save(calculationResult);
    }

    @Override
    public List<CalculationResult> findAllByUser(User user) {
        return resultRepository.findAllByUser(user);
    }

    @Override
    public List<CalculationResult> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        return resultRepository.delete(id);
    }

    @Override
    public boolean deleteAllByUser(User user) {
        return resultRepository.deleteAllByUser(user);
    }

}
