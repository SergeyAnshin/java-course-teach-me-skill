package org.anshin.service.impl;

import org.anshin.entity.User;
import org.anshin.enums.Role;
import org.anshin.repository.UserRepository;
import org.anshin.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean exists(User user) {
        return userRepository.exists(user);
    }

    @Override
    public boolean existsByEmailOrLogin(String email, String login) {
        return userRepository.existsByEmailAndLogin(email, login);
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

    @Override
    public boolean deleteById(Long id) {
        Optional<User> user = findById(id);
        if (user.isPresent() && !user.get().getRole().equals(Role.ADMIN)) {
            return userRepository.delete(id);
        } else {
            return false;
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
