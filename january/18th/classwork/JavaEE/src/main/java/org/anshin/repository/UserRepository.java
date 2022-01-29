package org.anshin.repository;

import java.util.List;

public interface UserRepository<T> {

    boolean exists(T user);

    boolean exists(String email, String login);

    boolean save(T user);

    T findByLogin(String login);

    T findByLoginAndPassword(String login, String password);

    List<T> findAll();

    boolean updatePasswordForUserWithEmail(String newPassword, String email);

    boolean existsByEmailAndKeyword(String email, String keyword);

    boolean update(T user);
}
