package org.anshin.service;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;

import java.util.List;

public interface CalculationResultService {

    boolean save(CalculationResult calculationResult);

    List<CalculationResult> findAllByUser(User user);

    List<CalculationResult> findAll();

    boolean deleteById(Long id);

    boolean deleteAllByUser(User user);
}
