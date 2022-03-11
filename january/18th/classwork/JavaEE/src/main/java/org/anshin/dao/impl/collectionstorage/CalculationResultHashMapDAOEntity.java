package org.anshin.dao.impl.collectionstorage;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;
import org.anshin.dao.CalculationResultDAO;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class CalculationResultHashMapDAOEntity implements CalculationResultDAO {
    private final Map<String, ArrayList<CalculationResult>> calculationResultStorage =
            new ConcurrentHashMap<>();

    @Override
    public boolean exists(CalculationResult calculationResult) {
        List<CalculationResult> userCalculationResults =
                calculationResultStorage.get(calculationResult.getUser().getLogin());
        return userCalculationResults != null && !userCalculationResults.isEmpty()
                && userCalculationResults.contains(calculationResult);
    }

    @Override
    public boolean save(CalculationResult calculationResult) {
        String login = calculationResult.getUser().getLogin();
        AtomicBoolean isSaved = new AtomicBoolean(false);
        calculationResultStorage.merge(login, new ArrayList<>(List.of(calculationResult)), (oldResultList, newResultList) -> {
            isSaved.set(oldResultList.addAll(newResultList));
            return oldResultList;
        });
        return isSaved.get();
    }

    @Override
    public List<CalculationResult> findAll() {
        return calculationResultStorage.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CalculationResult> findAllFromIdWithLimit(long id, long limit) {
        SortedSet<CalculationResult> users =
                new TreeSet<>(Comparator.comparing(CalculationResult::getId));
        List<CalculationResult> calculationResults = calculationResultStorage.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        users.addAll(calculationResults);
        return users.stream()
                .filter(calculationResult -> calculationResult.getId() >= id)
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<CalculationResult> findAllByUser(User user) {
        return calculationResultStorage.get(user.getLogin());
    }

    @Override
    public List<CalculationResult> findAllByUserAndOperation(User user, Operation operation) {
        List<CalculationResult> calculationResults = calculationResultStorage.get(user.getLogin());
        if (calculationResults != null && !calculationResults.isEmpty()) {
            return calculationResults.stream()
                    .filter(result -> result.getOperation().equals(operation))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean deleteAllByUser(User user) {
        throw new UnsupportedOperationException();
    }
}
