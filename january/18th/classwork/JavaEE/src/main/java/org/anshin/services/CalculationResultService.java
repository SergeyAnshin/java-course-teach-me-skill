package org.anshin.services;

import org.anshin.entities.User;
import org.anshin.enums.Operation;

import java.util.List;

public interface CalculationResultService<T> {

    boolean save(T calculationResult);

    List<T> findAllByUser(User user);

    List<T> findAll();
}
