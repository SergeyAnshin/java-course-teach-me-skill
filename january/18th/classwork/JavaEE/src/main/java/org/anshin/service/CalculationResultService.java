package org.anshin.service;

import org.anshin.entity.User;
import org.anshin.enums.Operation;

import java.util.List;

public interface CalculationResultService<T> {

    boolean save(T calculationResult);

    List<T> findAllByUser(User user);

    List<T> findAll();
}
