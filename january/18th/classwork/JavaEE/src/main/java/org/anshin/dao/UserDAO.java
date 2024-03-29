package org.anshin.dao;

import org.anshin.entity.User;

import java.util.Optional;

public interface UserDAO extends EntityGenericDAO<User> {

    boolean existsByEmailAndLogin(String email, String login);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);

    boolean updatePasswordForUserWithEmail(String newPassword, String email);

    boolean existsByEmailAndKeyword(String email, String keyword);

    boolean update(User user);

    Optional<User> findById(Long id);
}
