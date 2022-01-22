package org.anshin.services.impl;

import org.anshin.entities.User;
import org.anshin.repositories.UserRepository;
import org.anshin.repositories.impl.UserRepositoryImpl;
import org.anshin.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService<User> {
    private final UserRepository<User> userRepository = new UserRepositoryImpl();

    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
