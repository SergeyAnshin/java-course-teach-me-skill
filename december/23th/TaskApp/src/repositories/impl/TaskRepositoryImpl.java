package repositories.impl;

import entities.Task;
import mappers.repositories.impl.RepositoryTaskMapper;
import repositories.TaskRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static queries.TaskQueriesStorage.*;

public class TaskRepositoryImpl extends EntityCrudRepositoryImpl<Task> implements TaskRepository<Task> {

    public TaskRepositoryImpl() {
        super(new RepositoryTaskMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY);
    }

    @Override
    protected void executeSaveStatementForEntity(Task task, PreparedStatement statement) throws SQLException {
        statement.setString(1, task.getName());
        statement.setLong(2, task.getTaskCategory().getId());
        statement.setLong(3, task.getAuthor().getId());
        statement.execute();
    }

    @Override
    protected ResultSet executeExistStatementForEntity(Task task, PreparedStatement statement) throws SQLException {
        statement.setLong(1, task.getId());
        return statement.executeQuery();
    }

    @Override
    protected List<Task> getListEntitiesFromResultSet(ResultSet resultSet) {
        return entityMapper.fromResultSetToListEntity(resultSet);
    }

    @Override
    protected Task getEntityFromResultSet(ResultSet resultSet) {
        return entityMapper.fromResultSetToEntity(resultSet);
    }
}
