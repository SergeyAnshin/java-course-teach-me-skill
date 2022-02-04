package org.anshin.repository;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;

import java.util.List;

public interface CalculationResultRepository {

    boolean save(CalculationResult calculationResult);

    List<CalculationResult> findAll();

    List<CalculationResult> findAllByUser(User user);

    List<CalculationResult> findAllByUserAndOperation(User user, Operation operation);
}
