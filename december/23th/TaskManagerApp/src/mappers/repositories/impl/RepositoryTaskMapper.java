package mappers.repositories.impl;

import entities.Task;
import entities.TaskCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryTaskMapper extends RepositoryEntityMapperImpl<Task> {

    @Override
    protected Task getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return getEntityFromResultSetByColumnNumbers(resultSet, 1, 2);
    }

    @Override
    protected Task getEntityFromResultSetByColumnNumbers(ResultSet resultSet, int columnId, int columnName) throws SQLException {
        Long id = resultSet.getLong(columnId);
        String name = resultSet.getString(columnName);
        return new Task(id, name);
    }
}
