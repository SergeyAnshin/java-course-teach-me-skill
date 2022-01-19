package org.anshin.services.impl;

import org.anshin.entities.CalculationResult;
import org.anshin.enums.Operation;
import org.anshin.repositories.CalculatorRepository;
import org.anshin.repositories.impl.CalculatorRepositoryImpl;
import org.anshin.services.CalculatorService;

import java.util.List;
import java.util.stream.Collectors;

import static org.anshin.validators.ParameterValidator.isNumericParameterValid;
import static org.anshin.validators.ParameterValidator.isOperationParameterValid;

public class CalculatorServiceImpl implements CalculatorService<String> {
    private static final CalculatorRepository<CalculationResult<String>> REPOSITORY =
            new CalculatorRepositoryImpl();
    private static final String INVALID_PARAMETER_ERROR = "You entered an invalid parameter!";

    @Override
    public String calculate(String firstValue, String secondValue, String operation) {
        if (isNumericParameterValid(firstValue) && isNumericParameterValid(secondValue)
                && isOperationParameterValid(operation)) {

            Double result = Operation.valueOf(operation.toUpperCase())
                    .calculate(Double.parseDouble(firstValue), Double.parseDouble(secondValue));

            CalculationResult<String> calculationResult = new CalculationResult<>(String.valueOf(result));

            REPOSITORY.save(calculationResult);

            return String.valueOf(result);
        } else {
            return INVALID_PARAMETER_ERROR;
        }
    }

    @Override
    public List<String> getCalculationHistory() {
        return REPOSITORY.findAll()
                .stream()
                .map(CalculationResult::toString)
                .collect(Collectors.toList());
    }
}
