package mappers.repositories.impl;

import entities.TaskCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryTaskCategoryMapper extends RepositoryEntityMapperImpl<TaskCategory> {

    @Override
    protected TaskCategory getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return getEntityFromResultSetByColumnNumbers(resultSet,1, 2);
    }

    @Override
    protected TaskCategory getEntityFromResultSetByColumnNumbers(ResultSet resultSet, int columnId, int columnName) throws SQLException {
        Long id = resultSet.getLong(columnId);
        String name = resultSet.getString(columnName);
        return new TaskCategory(id, name);
    }
}
