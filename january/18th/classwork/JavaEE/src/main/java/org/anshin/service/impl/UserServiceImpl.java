package org.anshin.service.impl;

import org.anshin.entity.User;
import org.anshin.enums.Role;
import org.anshin.dao.UserDAO;
import org.anshin.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean exists(User user) {
        return userDAO.exists(user);
    }

    @Override
    public boolean existsByEmailOrLogin(String email, String login) {
        return userDAO.existsByEmailAndLogin(email, login);
    }

    @Override
    public boolean save(User user) {
        return !userDAO.exists(user) && userDAO.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userDAO.findByLoginAndPassword(login, password);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean updatePasswordForUserWithEmail(String newPassword, String email) {
        return userDAO.updatePasswordForUserWithEmail(newPassword, email);
    }

    @Override
    public boolean existsByEmailAndKeyword(String email, String keyword) {
        return userDAO.existsByEmailAndKeyword(email, keyword);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<User> user = findById(id);
        if (user.isPresent() && !user.get().getRole().equals(Role.ADMIN)) {
            return userDAO.delete(id);
        } else {
            return false;
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }
}
