package org.anshin.repository.impl.dbstorage;

import org.anshin.entity.CalculationResult;
import org.anshin.entity.User;
import org.anshin.enums.Operation;
import org.anshin.mapper.repository.RepositoryEntityMapper;
import org.anshin.mapper.repository.impl.RepositoryCalculationResultMapper;
import org.anshin.mapper.repository.impl.RepositoryUserMapper;
import org.anshin.repository.CalculationResultRepository;
import org.anshin.repository.ConnectionPool;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class CalculationResultDBRepository implements CalculationResultRepository {
    private final RepositoryEntityMapper<CalculationResult> calculationResultMapper =
            new RepositoryCalculationResultMapper();

    private static final String SQL_SELECT_CALCULATION_RESULT_WITHOUT_CONDITIONAL_PART =
            "SELECT cr.id, cr.first_value, cr.second_value, cr.result, cr.calculation_time, o.name AS operation_name " +
            "FROM calculation_result cr " +
            "INNER JOIN operation o ON cr.operation_id = o.id ";

    private static final String SQL_EXISTS_CALCULATION_RESULT =
            "SELECT \"id\" " +
            "FROM calculation_result " +
            "WHERE user_id = ? AND calculation_time = ? " +
            "LIMIT 1";

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

    @Override
    public List<CalculationResult> findAllByUser(User user) {
        List<CalculationResult> calculationResults = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_CALCULATION_RESULT_BY_USER);
            statement.setLong(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            calculationResults = calculationResultMapper.toListEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return calculationResults != null ? calculationResults : Collections.emptyList();
    }

    @Override
    public List<CalculationResult> findAllByUserAndOperation(User user, Operation operation) {
        List<CalculationResult> calculationResults = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_CALCULATION_RESULT_BY_USER_AND_OPERATION);
            statement.setLong(1, user.getId());
            statement.setLong(2, operation.getDBId());
            ResultSet resultSet = statement.executeQuery();
            calculationResults = calculationResultMapper.toListEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return calculationResults != null ? calculationResults : Collections.emptyList();
    }

    @Override
    public boolean deleteAllByUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isDeleted = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_ALL_CALCULATION_RESULT);
            statement.setLong(1, user.getId());
            isDeleted = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return isDeleted;
    }

    @Override
    public boolean exists(CalculationResult calculationResult) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean exists = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_EXISTS_CALCULATION_RESULT);
            statement.setLong(1, calculationResult.getUser().getId());
            statement.setObject(2, calculationResult.getCalculationTime());
            exists = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return exists;
    }

    @Override
    public boolean save(CalculationResult calculationResult) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isSaved = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_SAVE_CALCULATION_RESULT);
            statement.setDouble(1, calculationResult.getFirstValue());
            statement.setDouble(2, calculationResult.getSecondValue());
            statement.setDouble(3, calculationResult.getResult());
            statement.setObject(4, calculationResult.getCalculationTime());
            statement.setLong(5, calculationResult.getUser().getId());
            statement.setLong(6, calculationResult.getOperation().getDBId());
            isSaved = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return isSaved;
    }

    @Override
    public List<CalculationResult> findAll() {
        List<CalculationResult> calculationResults = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_CALCULATION_RESULT_WITHOUT_CONDITIONAL_PART);
            calculationResults = calculationResultMapper.toListEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return calculationResults != null ? calculationResults : Collections.emptyList();
    }

    @Override
    public boolean delete(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isDeleted = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_CALCULATION_RESULT);
            statement.setLong(1, id);
            isDeleted = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return isDeleted;
    }
}
