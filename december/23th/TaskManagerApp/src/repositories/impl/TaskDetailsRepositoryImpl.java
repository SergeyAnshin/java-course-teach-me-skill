package repositories.impl;

import entities.TaskDetails;
import mappers.repositories.impl.RepositoryTaskDetailsMapper;
import repositories.TaskDetailsRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import static queries.TaskDetailsQueriesStorage.*;

public class TaskDetailsRepositoryImpl extends AbstractEntityCrudRepositoryImpl<TaskDetails> implements TaskDetailsRepository<TaskDetails> {

    public TaskDetailsRepositoryImpl() {
        super(new RepositoryTaskDetailsMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY,
                UPDATE_QUERY, DELETE_QUERY);
    }

    @Override
    protected boolean executeSaveStatementForEntity(TaskDetails taskDetails, PreparedStatement statement) throws SQLException {
        statement.setLong(1, taskDetails.getProject().getId());
        statement.setLong(2, taskDetails.getAuthor().getId());
        return statement.execute();
    }

    @Override
    protected boolean executeExistStatementForEntity(TaskDetails taskDetails, PreparedStatement statement) throws SQLException {
        statement.setLong(1, taskDetails.getId());
        return statement.executeQuery().next();
    }

    @Override
    protected boolean executeUpdateStatementForEntity(TaskDetails taskDetails, PreparedStatement statement) throws SQLException {
        statement.setLong(1, taskDetails.getProject().getId());

        if (taskDetails.getTask() == null) {
            statement.setNull(2, Types.NULL);
        } else {
            statement.setLong(2, taskDetails.getTask().getId());
        }

        statement.setLong(3, taskDetails.getAuthor().getId());

        if (taskDetails.getExecutor() == null) {
            statement.setNull(4, Types.NULL);
        } else {
            statement.setLong(4, taskDetails.getExecutor().getId());
        }

        statement.setLong(5, taskDetails.getId());

        return statement.executeUpdate() != 0;
    }

    @Override
    protected boolean executeDeleteStatementForEntity(TaskDetails taskDetails, PreparedStatement statement) throws SQLException {
        statement.setLong(1, taskDetails.getId());
        return statement.executeUpdate() != 0;
    }
}
