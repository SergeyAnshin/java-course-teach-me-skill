package org.anshin.repositories.impl;

import org.anshin.entities.CalculationResult;
import org.anshin.entities.User;
import org.anshin.repositories.CalculationResultRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class CalculationResultRepositoryImpl implements CalculationResultRepository<CalculationResult<String>> {
    private static final Map<String, ArrayList<CalculationResult<String>>> calculationResultStorage = new HashMap<>();

    @Override
    public boolean save(CalculationResult<String> calculationResult) {
        String login = calculationResult.getUser().getLogin();
        AtomicBoolean isSaved = new AtomicBoolean(false);
        calculationResultStorage.merge(login, new ArrayList<>(List.of(calculationResult)), (oldResultList, newResultList) -> {
            isSaved.set(oldResultList.addAll(newResultList));
            return oldResultList;
        });
        return isSaved.get();
    }

    @Override
    public List<CalculationResult<String>> findAll() {
        return calculationResultStorage.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<CalculationResult<String>> findAllByUser(User user) {
        return calculationResultStorage.get(user.getLogin());
    }
}
