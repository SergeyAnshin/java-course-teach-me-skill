package org.anshin.repository.impl.jdbcstorage;

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
public class UserJDBCRepository implements UserRepository {
    private final RepositoryEntityMapper<User> userMapper;

    private static final String SQL_SELECT_USERS_WITHOUT_CONDITIONAL_PART =
            "SELECT u.*, r.name AS role_name " +
            "FROM user u " +
            "INNER JOIN role r ON u.role_id = r.id ";

    private static final String SQL_EXISTS_USER =
            "SELECT COUNT(id) " +
            "FROM user " +
            "WHERE email = ? OR login = ?";

    private static final String SQL_SAVE_USER =
            "INSERT INTO user (email, login, password, role_id) " +
            "VALUES (?, ?, ?, (" +
                    "SELECT id " +
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
            "UPDATE user SET password = ? WHERE email = ?";

    private static final String SQL_EXISTS_USER_BY_EMAIL_AND_KEYWORD =
            "SELECT COUNT(id) " +
            "FROM user " +
            "WHERE email = ? AND keyword = ? ";

    private static final String SQL_UPDATE_USER =
            "UPDATE user SET email = ?, login = ?, password = ?, keyword = ?, role_id = ? WHERE id = ?";

    private static final String SQL_DELETE_USER = "DELETE FROM user WHERE id = ?";

    private static final String SQL_SELECT_USER_BY_ID =
            SQL_SELECT_USERS_WITHOUT_CONDITIONAL_PART +
            "WHERE u.id = ?";


    public UserJDBCRepository() {
        userMapper = new RepositoryUserMapper();
    }

    public UserJDBCRepository(RepositoryEntityMapper<User> userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean exists(User user) {
        boolean exists = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_EXISTS_USER)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getLogin());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public boolean save(User user) {
        boolean isSaved = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SAVE_USER)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().name());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            users = userMapper.toListEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users != null ? users : Collections.emptyList();
    }

    @Override
    public boolean delete(Long id) {
        boolean isDeleted = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER)) {
            statement.setLong(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public boolean existsByEmailAndLogin(String email, String login) {
        boolean exists = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_EXISTS_USER)) {
            statement.setString(1, email);
            statement.setString(2, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        User user = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            user = userMapper.toEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        User user = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            user = userMapper.toEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean updatePasswordForUserWithEmail(String newPassword, String email) {
        boolean isUpdated = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER_PASSWORD_BY_EMAIL)) {
            statement.setString(1, newPassword);
            statement.setString(2, email);
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean existsByEmailAndKeyword(String email, String keyword) {
        boolean exists = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_EXISTS_USER_BY_EMAIL_AND_KEYWORD)) {
            statement.setString(1, email);
            statement.setString(2, keyword);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public boolean update(User user) {
        boolean isUpdated = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getKeyword());
            statement.setLong(5, user.getRole().getDBId());
            statement.setLong(6, user.getId());
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            user = userMapper.toEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }
}
