package org.anshin.repositories;

import java.util.List;

public interface UserRepository<T> {

    boolean save(T user);

    T findByLogin(String login);

    T findByLoginAndPassword(String login, String password);

    List<T> findAll();
}
