package org.anshin.mapper.repository.impl;

import org.anshin.entity.CalculationResult;
import org.anshin.enums.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class RepositoryCalculationResultMapper extends RepositoryEntityMapperImpl<CalculationResult> {

    private static final String LABEL_ID_COLUMN = "id";
    private static final String LABEL_FIRST_VALUE_COLUMN = "first_value";
    private static final String LABEL_SECOND_VALUE_COLUMN = "second_value";
    private static final String LABEL_RESULT_COLUMN = "result";
    private static final String LABEL_CALCULATION_TIME_COLUMN = "calculation_time";
    private static final String LABEL_OPERATION_NAME_COLUMN = "operation_name";

    @Override
    protected CalculationResult getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setId(resultSet.getLong(LABEL_ID_COLUMN));
        calculationResult.setFirstValue(resultSet.getDouble(LABEL_FIRST_VALUE_COLUMN));
        calculationResult.setSecondValue(resultSet.getDouble(LABEL_SECOND_VALUE_COLUMN));
        calculationResult.setResult(resultSet.getDouble(LABEL_RESULT_COLUMN));
        Timestamp calculationTime = (Timestamp) resultSet.getObject(LABEL_CALCULATION_TIME_COLUMN);
        calculationResult.setCalculationTime(calculationTime.toLocalDateTime());
        calculationResult.setOperation(Operation.valueOf(resultSet.getString(LABEL_OPERATION_NAME_COLUMN)));
        return calculationResult;
    }
}
