package repositories.impl;

import entities.TaskCategory;
import mappers.repositories.impl.RepositoryTaskCategoryMapper;
import repositories.TaskCategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static queries.TaskCategoryQueriesStorage.*;


public class TaskCategoryRepositoryImpl extends EntityCrudRepositoryImpl<TaskCategory> implements TaskCategoryRepository<TaskCategory> {

    public TaskCategoryRepositoryImpl() {
        super(new RepositoryTaskCategoryMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY);
    }

    @Override
    protected void executeSaveStatementForEntity(TaskCategory taskCategory, PreparedStatement statement) throws SQLException {
        statement.setString(1, taskCategory.getName());
        statement.execute();
    }

    @Override
    protected ResultSet executeExistStatementForEntity(TaskCategory taskCategory, PreparedStatement statement) throws SQLException {
        statement.setString(1, taskCategory.getName());
        return statement.executeQuery();
    }

    @Override
    protected List<TaskCategory> getListEntitiesFromResultSet(ResultSet resultSet) {
        return entityMapper.fromResultSetToListEntity(resultSet);
    }

    @Override
    protected TaskCategory getEntityFromResultSet(ResultSet resultSet) {
        return entityMapper.fromResultSetToEntity(resultSet);
    }
}
