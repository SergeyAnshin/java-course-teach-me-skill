package org.anshin.repository.impl.dbstorage;

import org.anshin.entity.User;
import org.anshin.mapper.repository.RepositoryEntityMapper;
import org.anshin.mapper.repository.impl.RepositoryUserMapper;
import org.anshin.repository.ConnectionPool;
import org.anshin.repository.UserRepository;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * questions:
 * 1. extract common line - best practice?
 * 2. update user - update within table or other? update all columns or that have been changed?
 * 3. matching a role ID from db and enum
 */
public class UserDBRepository implements UserRepository {
    private final RepositoryEntityMapper<User> userMapper = new RepositoryUserMapper();

    private static final String SQL_SELECT_USERS_WITHOUT_CONDITIONAL_PART =
            "SELECT u.*, r.name AS role_name " +
            "FROM \"user\" u " +
            "INNER JOIN role r ON u.role_id = r.id ";

    private static final String SQL_EXISTS_USER =
            "SELECT \"id\" " +
            "FROM \"user\" " +
            "WHERE email = ? OR login = ? " +
            "LIMIT 1";

    private static final String SQL_SAVE_USER =
            "INSERT INTO \"user\" (email, login, password, role_id) " +
            "VALUES (?, ?, ?, (" +
                    "SELECT \"id\" " +
                    "FROM role " +
                    "WHERE name = ? " +
                    "LIMIT 1))";

    private static final String SQL_SELECT_ALL_USERS = SQL_SELECT_USERS_WITHOUT_CONDITIONAL_PART;

    private static final String SQL_SELECT_USER_BY_LOGIN =
            SQL_SELECT_USERS_WITHOUT_CONDITIONAL_PART +
            "WHERE login = ?";

    private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD =
            SQL_SELECT_USERS_WITHOUT_CONDITIONAL_PART +
            "WHERE login = ? AND password = ? " +
            "LIMIT 1";

    private static final String SQL_UPDATE_USER_PASSWORD_BY_EMAIL =
            "UPDATE \"user\" SET password = ? WHERE email = ?";

    private static final String SQL_EXISTS_USER_BY_EMAIL_AND_KEYWORD =
            "SELECT \"id\" " +
            "FROM \"user\" " +
            "WHERE email = ? AND keyword = ? " +
            "LIMIT 1";

    private static final String SQL_UPDATE_USER =
            "UPDATE \"user\" SET email = ?, login = ?, password = ?, keyword = ?, role_id = ? WHERE id = ?";


    @Override
    public boolean exists(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean exists = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_EXISTS_USER);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getLogin());
            exists = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return exists;
    }

    @Override
    public boolean save(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isSaved = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_SAVE_USER);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().name());
            isSaved = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return isSaved;
    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            users = userMapper.toListEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return users != null ? users : Collections.emptyList();
    }

    @Override
    public boolean exists(String email, String login) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean exists = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_EXISTS_USER);
            statement.setString(1, email);
            statement.setString(2, login);
            exists = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return exists;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Connection connection = null;
        PreparedStatement statement = null;
        User user = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            user = userMapper.toEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        User user = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            user = userMapper.toEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean updatePasswordForUserWithEmail(String newPassword, String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isUpdated = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_USER_PASSWORD_BY_EMAIL);
            statement.setString(1, newPassword);
            statement.setString(2, email);
            isUpdated = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return isUpdated;
    }

    @Override
    public boolean existsByEmailAndKeyword(String email, String keyword) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean exists = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_EXISTS_USER_BY_EMAIL_AND_KEYWORD);
            statement.setString(1, email);
            statement.setString(2, keyword);
            exists = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return exists;
    }

    @Override
    public boolean update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isUpdated = false;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_USER);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getKeyword());
            statement.setLong(5, user.getRole().getDBId());
            statement.setLong(6, user.getId());
            isUpdated = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return isUpdated;
    }
}
