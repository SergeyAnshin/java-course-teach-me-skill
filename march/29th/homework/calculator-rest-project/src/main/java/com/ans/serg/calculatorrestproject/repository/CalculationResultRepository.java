package com.ans.serg.calculatorrestproject.repository;

import com.ans.serg.calculatorrestproject.entity.CalculationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculationResultRepository extends JpaRepository<CalculationResult, Long> {

    List<CalculationResult> findAllByUserId(long id);
}
