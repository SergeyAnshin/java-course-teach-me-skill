package org.anshin.service.impl;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.repository.CalculationResultRepository;
import org.anshin.repository.impl.collectionstorage.CalculationResultHashMapRepository;
import org.anshin.repository.impl.dbstorage.CalculationResultDBRepository;
import org.anshin.service.CalculationResultService;

import java.util.List;

public class CalculationResultServiceImpl implements CalculationResultService {
    private final CalculationResultRepository resultRepository = new CalculationResultDBRepository();

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

}
