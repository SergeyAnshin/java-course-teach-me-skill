package org.anshin.services;

import org.anshin.entities.User;

import java.util.List;

public interface CalculationResultService<T> {

    boolean save(T calculationResult);

    List<T> getCalculationResultHistoryForUser(User user);

    List<T> findAll();

}
