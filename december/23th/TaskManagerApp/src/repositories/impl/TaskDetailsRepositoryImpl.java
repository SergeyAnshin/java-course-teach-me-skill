package repositories.impl;

import entities.TaskDetails;
import mappers.repositories.impl.RepositoryTaskDetailsMapper;
import repositories.TaskDetailsRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static queries.TaskDetailsQueriesStorage.*;

public class TaskDetailsRepositoryImpl extends AbstractEntityCrudRepositoryImpl<TaskDetails> implements TaskDetailsRepository<TaskDetails> {

    public TaskDetailsRepositoryImpl() {
        super(new RepositoryTaskDetailsMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY,
                UPDATE_QUERY, DELETE_QUERY);
    }

    @Override
    protected boolean executeSaveStatementForEntity(TaskDetails taskDetails, PreparedStatement statement) throws SQLException {
        return false;
    }

    @Override
    protected boolean executeExistStatementForEntity(TaskDetails taskDetails, PreparedStatement statement) throws SQLException {
        return false;
    }

    @Override
    protected boolean executeUpdateStatementForEntity(TaskDetails taskDetails, PreparedStatement statement) throws SQLException {
        return false;
    }

    @Override
    protected boolean executeDeleteStatementForEntity(TaskDetails taskDetails, PreparedStatement statement) throws SQLException {
        return false;
    }


}
