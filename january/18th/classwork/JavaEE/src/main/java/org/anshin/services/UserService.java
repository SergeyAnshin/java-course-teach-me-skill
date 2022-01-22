package org.anshin.services;

import org.anshin.entities.User;

import java.util.List;

public interface UserService<T> {

    boolean save(User user);

    T findByLogin(String login);

    T findByLoginAndPassword(String login, String password);

    List<T> findAll();
}
