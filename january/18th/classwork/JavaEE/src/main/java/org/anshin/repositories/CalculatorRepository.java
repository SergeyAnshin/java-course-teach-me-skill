package org.anshin.repositories;

import java.util.List;

public interface CalculatorRepository<T> {

    boolean save(T calculationResult);

    List<T> findAll();
}
