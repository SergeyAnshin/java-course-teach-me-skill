package org.anshin.repositories.impl;

import org.anshin.entities.User;
import org.anshin.enums.Role;
import org.anshin.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository<User> {
    private static final Map<String, User> userStorage = new HashMap<>();

    public UserRepositoryImpl() {
        User admin = new User("admin", "admin", Role.ADMIN);
        userStorage.putIfAbsent("admin", admin);
    }

    @Override
    public boolean save(User user) {
        return userStorage.putIfAbsent(user.getLogin(), user) == null;
    }

    @Override
    public User findByLogin(String login) {
        return !userStorage.isEmpty() ? userStorage.get(login) : null;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        if (!userStorage.isEmpty()) {
            User user = userStorage.get(login);
            if (user != null) {
                return user.getPassword().equals(password) ? user : null;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userStorage.values());
    }
}
