package org.anshin.repositories;

import org.anshin.entities.User;
import org.anshin.enums.Operation;

import java.util.List;

public interface CalculationResultRepository<T> {

    boolean save(T calculationResult);

    List<T> findAll();

    List<T> findAllByUser(User user);

    List<T> findAllByUserAndOperation(User user, Operation operation);
}
