package com.ans.serg.calculatorspringboot.dao;

import com.ans.serg.calculatorspringboot.entity.CalculationResult;
import com.ans.serg.calculatorspringboot.entity.User;

import java.util.List;

public interface CalculationResultDAO extends GenericDAO<CalculationResult> {

    List<CalculationResult> findAllByUser(User user);
}
