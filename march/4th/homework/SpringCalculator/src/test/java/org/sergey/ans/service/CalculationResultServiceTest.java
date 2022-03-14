package org.sergey.ans.service;

import org.junit.jupiter.api.*;

import org.sergey.ans.dao.CalculationResultDAO;
import org.sergey.ans.dao.impl.collectionstorage.CalculationResultListStorage;
import org.sergey.ans.entity.CalculationResult;
import org.sergey.ans.entity.TwoVariableMathExpression;
import org.sergey.ans.enums.Operation;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculationResultServiceTest {
    private static CalculationResultDAO calculationResultDAO;
    private static CalculationResultService resultService;

    private static CalculationResult<TwoVariableMathExpression> calculationResult;
    private static CalculationResult<TwoVariableMathExpression> calculationResult1;
    private static CalculationResult<TwoVariableMathExpression> calculationResult2;
    private static CalculationResult<TwoVariableMathExpression> calculationResult3;
    private static CalculationResult<TwoVariableMathExpression> calculationResult4;

    @BeforeAll
    static void init() {
        calculationResultDAO = new CalculationResultListStorage();
        resultService = new CalculationResultService(calculationResultDAO);

        TwoVariableMathExpression expression = new TwoVariableMathExpression(1D, 0.5, Operation.SUM);
        TwoVariableMathExpression expression1 = new TwoVariableMathExpression(3D, 2D, Operation.DIVIDE);
        TwoVariableMathExpression expression2 = new TwoVariableMathExpression(2D, 0.5, Operation.SUBTRACT);
        TwoVariableMathExpression expression3 = new TwoVariableMathExpression(3D, 0.5, Operation.MULTIPLY);
        TwoVariableMathExpression expression4 = new TwoVariableMathExpression(3D, 0.5, Operation.MULTIPLY);

        calculationResult = new CalculationResult<>(expression, 1.5);
        calculationResult1 = new CalculationResult<>(expression1, 1.5);
        calculationResult2 = new CalculationResult<>(expression2, 1.5);
        calculationResult3 = new CalculationResult<>(expression3, 1.5);
        calculationResult4 = new CalculationResult<>(expression4, 1.5);
    }

    @Test
    @Order(1)
    void save() {
        assertTrue(resultService.save(calculationResult));
        assertTrue(resultService.save(calculationResult1));
        assertTrue(resultService.save(calculationResult2));
        assertTrue(resultService.save(calculationResult3));
        assertFalse(resultService.save(calculationResult4));
    }

    @Test
    @Order(2)
    void findAll() {
        CalculationResult[] expectedResultArray = {
            calculationResult, calculationResult1, calculationResult2, calculationResult3
        };

        assertArrayEquals(expectedResultArray, resultService.findAll().toArray());
    }
}