package repositories.impl;

import entities.User;
import mappers.repositories.impl.RepositoryUserMapper;
import repositories.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static queries.UserQueriesStorage.*;

public class UserRepositoryImpl extends EntityCrudRepositoryImpl<User> implements UserRepository<User> {

    public UserRepositoryImpl() {
        super(new RepositoryUserMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY);
    }

    @Override
    protected void executeSaveStatementForEntity(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
        statement.execute();
    }

    @Override
    protected ResultSet executeExistStatementForEntity(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getEmail());
        return statement.executeQuery();
    }

    @Override
    protected List<User> getListEntitiesFromResultSet(ResultSet resultSet) {
        return entityMapper.fromResultSetToListEntity(resultSet);
    }

    @Override
    protected User getEntityFromResultSet(ResultSet resultSet) {
        return entityMapper.fromResultSetToEntity(resultSet);
    }
}
