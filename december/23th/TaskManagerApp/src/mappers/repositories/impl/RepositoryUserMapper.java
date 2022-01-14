package mappers.repositories.impl;

import entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryUserMapper extends RepositoryEntityMapperImpl<User> {

    @Override
    protected User getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return getEntityFromResultSetByColumnNumbers(resultSet, 1, 2, 3, 4);
    }

    @Override
    protected User getEntityFromResultSetByColumnNumbers(ResultSet resultSet, int columnId, int columnLogin,
                                                         int columnEmail, int columnPassword) throws SQLException {
        long id = resultSet.getLong(columnId);
        if (id != 0) {
            String login = resultSet.getString(columnLogin);
            String email = resultSet.getString(columnEmail);
            String password = resultSet.getString(columnPassword);
            return new User(id, login, email, password);
        }
        return null;
    }
}
