package mappers.repositories.impl;

import entities.TaskCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryTaskCategoryMapper extends RepositoryEntityMapperImpl<TaskCategory> {

    @Override
    protected TaskCategory getEntityFromResultSet(ResultSet resultSet) {
        return fromResultSetToEntityByColumnIndex(resultSet, 1, 2);
    }

    @Override
    protected TaskCategory fromResultSetToEntityByColumnIndex(ResultSet resultSet, int indexIdColumn, int indexNameColumn) {
        try {
            Long id = resultSet.getLong(indexIdColumn);
            String name = resultSet.getString(indexNameColumn);
            return new TaskCategory(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
