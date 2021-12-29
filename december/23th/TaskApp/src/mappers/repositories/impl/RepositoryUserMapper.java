package mappers.repositories.impl;

import entities.Task;
import entities.TaskCategory;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryUserMapper extends RepositoryEntityMapperImpl<User> {

    @Override
    protected User getEntityFromResultSet(ResultSet resultSet) {
        return fromResultSetToEntityByColumnIndex(resultSet, 1, 2, 3, 4);
    }


    @Override
    protected User fromResultSetToEntityByColumnIndex(ResultSet resultSet, int indexIdColumn,
                                                      int indexLoginColumn, int indexPasswordColumn,
                                                      int indexEmailColumn) {
        try {
            Long id = resultSet.getLong(indexIdColumn);
            String login = resultSet.getString(indexLoginColumn);
            String password = resultSet.getString(indexPasswordColumn);
            String email = resultSet.getString(indexEmailColumn);
            return new User(id, login, password, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
