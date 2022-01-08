package mappers.repositories.impl;

import entities.TaskDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryTaskDetailsMapper extends RepositoryEntityMapperImpl<TaskDetails> {

    @Override
    protected TaskDetails getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}
