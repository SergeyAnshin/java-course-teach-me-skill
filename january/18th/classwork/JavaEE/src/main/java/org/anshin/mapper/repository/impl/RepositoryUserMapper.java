package org.anshin.mapper.repository.impl;

import org.anshin.entity.User;
import org.anshin.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryUserMapper extends RepositoryEntityMapperImpl<User> {
    private static final String LABEL_ID_COLUMN = "id";
    private static final String LABEL_EMAIL_COLUMN = "email";
    private static final String LABEL_LOGIN_COLUMN = "login";
    private static final String LABEL_PASSWORD_COLUMN = "password";
    private static final String LABEL_ROLE_NAME_COLUMN = "role_name";
    private static final String LABEL_KEYWORD_COLUMN = "keyword";

    @Override
    protected User getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(LABEL_ID_COLUMN));
        user.setEmail(resultSet.getString(LABEL_EMAIL_COLUMN));
        user.setLogin(resultSet.getString(LABEL_LOGIN_COLUMN));
        user.setPassword(resultSet.getString(LABEL_PASSWORD_COLUMN));
        user.setKeyword(resultSet.getString(LABEL_KEYWORD_COLUMN));
        user.setRole(Role.valueOf(resultSet.getString(LABEL_ROLE_NAME_COLUMN)));
        return user;
    }
}
