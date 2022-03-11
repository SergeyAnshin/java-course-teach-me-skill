package org.anshin.dao;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;

import java.util.List;

public interface CalculationResultDAO extends EntityGenericDAO<CalculationResult> {

    List<CalculationResult> findAllByUser(User user);

    List<CalculationResult> findAllByUserAndOperation(User user, Operation operation);

    boolean deleteAllByUser(User user);
}
