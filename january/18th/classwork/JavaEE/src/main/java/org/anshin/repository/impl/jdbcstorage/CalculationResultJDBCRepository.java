package org.anshin.repository.impl.jdbcstorage;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;
import org.anshin.mapper.repository.RepositoryEntityMapper;
import org.anshin.mapper.repository.impl.RepositoryCalculationResultMapper;
import org.anshin.repository.CalculationResultRepository;
import org.anshin.repository.ConnectionPool;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class CalculationResultJDBCRepository implements CalculationResultRepository {
    private final RepositoryEntityMapper<CalculationResult> calculationResultMapper;

    private static final String SQL_SELECT_CALCULATION_RESULT_WITHOUT_CONDITIONAL_PART =
            "SELECT cr.id, cr.first_value, cr.second_value, cr.result, cr.calculation_time, o.name AS operation_name " +
            "FROM calculation_result cr " +
            "INNER JOIN operation o ON cr.operation_id = o.id ";

    private static final String SQL_EXISTS_CALCULATION_RESULT =
            "SELECT COUNT(\"id\") " +
            "FROM calculation_result " +
            "WHERE user_id = ? AND calculation_time = ? ";

    private static final String SQL_SAVE_CALCULATION_RESULT =
            "INSERT INTO calculation_result (first_value, second_value, result, calculation_time, user_id, operation_id) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_ALL_CALCULATION_RESULT = SQL_SELECT_CALCULATION_RESULT_WITHOUT_CONDITIONAL_PART;

    private static final String SQL_SELECT_ALL_CALCULATION_RESULT_BY_USER =
            SQL_SELECT_CALCULATION_RESULT_WITHOUT_CONDITIONAL_PART +
            "WHERE user_id = ?";

    private static final String SQL_SELECT_ALL_CALCULATION_RESULT_BY_USER_AND_OPERATION =
            SQL_SELECT_CALCULATION_RESULT_WITHOUT_CONDITIONAL_PART +
            "WHERE user_id = ? AND operation_id = ?";

    private static final String SQL_DELETE_CALCULATION_RESULT = "DELETE FROM calculation_result WHERE id = ?";

    private static final String SQL_DELETE_ALL_CALCULATION_RESULT = "DELETE FROM calculation_result WHERE user_id = ?";


    public CalculationResultJDBCRepository() {
        calculationResultMapper = new RepositoryCalculationResultMapper();
    }

    public CalculationResultJDBCRepository(RepositoryEntityMapper<CalculationResult> calculationResultMapper) {
        this.calculationResultMapper = calculationResultMapper;
    }

    @Override
    public List<CalculationResult> findAllByUser(User user) {
        List<CalculationResult> calculationResults = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_CALCULATION_RESULT_BY_USER)) {
            statement.setLong(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            calculationResults = calculationResultMapper.toListEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calculationResults != null ? calculationResults : Collections.emptyList();
    }

    @Override
    public List<CalculationResult> findAllByUserAndOperation(User user, Operation operation) {
        List<CalculationResult> calculationResults = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_CALCULATION_RESULT_BY_USER_AND_OPERATION)) {
            statement.setLong(1, user.getId());
            statement.setLong(2, operation.getDBId());
            ResultSet resultSet = statement.executeQuery();
            calculationResults = calculationResultMapper.toListEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calculationResults != null ? calculationResults : Collections.emptyList();
    }

    @Override
    public boolean deleteAllByUser(User user) {
        boolean isDeleted = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL_CALCULATION_RESULT)) {
            statement.setLong(1, user.getId());
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public boolean exists(CalculationResult calculationResult) {
        boolean exists = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_EXISTS_CALCULATION_RESULT)) {
            statement.setLong(1, calculationResult.getUser().getId());
            statement.setObject(2, calculationResult.getCalculationTime());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public boolean save(CalculationResult calculationResult) {
        boolean isSaved = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SAVE_CALCULATION_RESULT)) {
            statement.setDouble(1, calculationResult.getFirstValue());
            statement.setDouble(2, calculationResult.getSecondValue());
            statement.setDouble(3, calculationResult.getResult());
            statement.setObject(4, calculationResult.getCalculationTime());
            statement.setLong(5, calculationResult.getUser().getId());
            statement.setLong(6, calculationResult.getOperation().getDBId());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public List<CalculationResult> findAll() {
        List<CalculationResult> calculationResults = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_CALCULATION_RESULT_WITHOUT_CONDITIONAL_PART);
            calculationResults = calculationResultMapper.toListEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calculationResults != null ? calculationResults : Collections.emptyList();
    }

    @Override
    public boolean delete(Long id) {
        boolean isDeleted = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_CALCULATION_RESULT)) {
            statement.setLong(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
