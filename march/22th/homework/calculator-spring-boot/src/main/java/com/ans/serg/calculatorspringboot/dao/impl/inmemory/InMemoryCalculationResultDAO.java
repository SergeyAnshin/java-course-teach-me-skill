package com.ans.serg.calculatorspringboot.dao.impl.inmemory;

import com.ans.serg.calculatorspringboot.dao.CalculationResultDAO;
import com.ans.serg.calculatorspringboot.entity.CalculationResult;
import com.ans.serg.calculatorspringboot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class InMemoryCalculationResultDAO implements CalculationResultDAO {
    private final ConcurrentHashMap<String, ArrayList<CalculationResult>> calculationResults = new ConcurrentHashMap<>();
    private final Logger logger = LoggerFactory.getLogger(InMemoryCalculationResultDAO.class);

    @Override
    public boolean exists(CalculationResult calculationResult) {
        List<CalculationResult> results = calculationResults.get(calculationResult.getUser().getEmail());
        boolean exists = results != null && !results.isEmpty() && results.contains(calculationResult);
        logger.info("IN MEMORY CALCULATION RESULT DAO - EXISTS: calculation result exists = " + exists);
        return exists;
    }

    @Override
    public boolean save(CalculationResult calculationResult) {
        String email = calculationResult.getUser().getEmail();
        logger.info("IN MEMORY CALCULATION RESULT DAO - SAVE: size before save = " + calculationResults.getOrDefault(email, new ArrayList<>()).size());
        AtomicBoolean isSaved = new AtomicBoolean(false);
        calculationResults.merge(email, new ArrayList<>(List.of(calculationResult)), (oldResultList, newResultList) -> {
            isSaved.set(oldResultList.addAll(newResultList));
            return oldResultList;
        });
        logger.info("IN MEMORY CALCULATION RESULT DAO - SAVE: size after save = " + calculationResults.getOrDefault(email, new ArrayList<>()).size());
        return isSaved.get();
    }

    @Override
    public List<CalculationResult> findAllByUser(User user) {
        return calculationResults.get(user.getEmail());
    }
}
