package repositories.impl;

import entities.User;
import mappers.repositories.impl.RepositoryUserMapper;
import repositories.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static queries.UserQueriesStorage.*;

public class UserRepositoryImpl extends AbstractEntityCrudRepositoryImpl<User> implements UserRepository<User>{

    public UserRepositoryImpl() {
        super(new RepositoryUserMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY,
                UPDATE_QUERY, DELETE_QUERY);
    }

    @Override
    protected boolean executeSaveStatementForEntity(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        return statement.executeUpdate() != 0;
    }

    @Override
    protected boolean executeExistStatementForEntity(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getEmail());
        return statement.executeQuery().next();
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(FIND_BY_LOGIN_AND_PASSWORD_QUERY);
                return executeFindByLoginAndPasswordStatement(login, password, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(NO_CONNECTION_MESSAGE);
        }
        return null;
    }

    private User executeFindByLoginAndPasswordStatement(String login, String password, PreparedStatement statement) throws SQLException {
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        return entityMapper.toEntityFromResultSet(resultSet);
    }

    @Override
    protected boolean executeUpdateStatementForEntity(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setLong(4, user.getId());
        return statement.executeUpdate() != 0;
    }

    @Override
    protected boolean executeDeleteStatementForEntity(User user, PreparedStatement statement) throws SQLException {
        statement.setLong(1, user.getId());
        return statement.execute();
    }

    @Override
    public User findByLogin(String login) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(FIND_BY_LOGIN_QUERY);
                return executeFindByLoginStatement(login, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(NO_CONNECTION_MESSAGE);
        }
        return null;
    }

    private User executeFindByLoginStatement(String login, PreparedStatement statement) throws SQLException {
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        return entityMapper.toEntityFromResultSet(resultSet);
    }
}
