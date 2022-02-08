package org.anshin.service;

import org.anshin.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean exists(User user);

    boolean exists(String email, String login);

    boolean save(User user);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);

    List<User> findAll();

    boolean updatePasswordForUserWithEmail(String newPassword, String email);

    boolean existsByEmailAndKeyword(String email, String keyword);

    boolean update(User user);

    boolean delete(Long id);

    Optional<User> findById(Long id);
}
