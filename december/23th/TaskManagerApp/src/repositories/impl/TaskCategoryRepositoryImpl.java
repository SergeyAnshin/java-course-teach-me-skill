package repositories.impl;

import entities.TaskCategory;
import mappers.repositories.impl.RepositoryTaskCategoryMapper;
import repositories.TaskCategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static queries.TaskCategoryQueriesStorage.*;

public class TaskCategoryRepositoryImpl extends AbstractEntityCrudRepositoryImpl<TaskCategory> implements TaskCategoryRepository<TaskCategory> {

    public TaskCategoryRepositoryImpl() {
        super(new RepositoryTaskCategoryMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY,
                UPDATE_QUERY, DELETE_QUERY);
    }

    @Override
    protected boolean executeSaveStatementForEntity(TaskCategory taskCategory, PreparedStatement statement) throws SQLException {
        statement.setString(1, taskCategory.getName());
        return statement.executeUpdate() != 0;
    }

    @Override
    protected boolean executeExistStatementForEntity(TaskCategory taskCategory, PreparedStatement statement) throws SQLException {
        return false;
    }

    @Override
    protected boolean executeUpdateStatementForEntity(TaskCategory taskCategory, PreparedStatement statement) throws SQLException {
        return false;
    }

    @Override
    protected boolean executeDeleteStatementForEntity(TaskCategory taskCategory, PreparedStatement statement) throws SQLException {
        return false;
    }
}
