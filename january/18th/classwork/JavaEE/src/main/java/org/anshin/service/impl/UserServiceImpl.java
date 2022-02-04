package org.anshin.service.impl;

import org.anshin.entity.User;
import org.anshin.repository.UserRepository;
import org.anshin.repository.impl.UserHashMapRepository;
import org.anshin.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserHashMapRepository();

    @Override
    public boolean exists(User user) {
        return userRepository.exists(user);
    }

    @Override
    public boolean exists(String email, String login) {
        return userRepository.exists(email, login);
    }

    @Override
    public boolean save(User user) {
        return !userRepository.exists(user) && userRepository.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean updatePasswordForUserWithEmail(String newPassword, String email) {
        return userRepository.updatePasswordForUserWithEmail(newPassword, email);
    }

    @Override
    public boolean existsByEmailAndKeyword(String email, String keyword) {
        return userRepository.existsByEmailAndKeyword(email, keyword);
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }
}
