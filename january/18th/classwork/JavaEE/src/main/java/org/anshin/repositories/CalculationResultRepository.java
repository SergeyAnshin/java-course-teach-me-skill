package org.anshin.repositories;

import org.anshin.entities.User;

import java.util.List;

public interface CalculationResultRepository<T> {

    boolean save(T calculationResult);

    List<T> findAll();

    List<T> findAllByUser(User user);
}
