package com.ans.serg.calculatorspringboot.dao.impl.inmemory;

import com.ans.serg.calculatorspringboot.dao.UserDAO;
import com.ans.serg.calculatorspringboot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryUserDAO implements UserDAO {
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
    private final Logger logger = LoggerFactory.getLogger(InMemoryUserDAO.class);

    @Override
    public boolean exists(User user) {
        boolean exists = users.contains(user);
        logger.info("IN MEMORY USER DAO - EXISTS: user exists = " + exists);
        return exists;
    }

    @Override
    public boolean save(User user) {
        logger.info("IN MEMORY USER DAO - SAVE: size before save = " + users.size());
        users.put(user.getEmail(), user);
        logger.info("IN MEMORY USER DAO - SAVE: size before save = " + users.size());
        return true;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = users.get(email);
        logger.info("IN MEMORY USER DAO - FIND BY EMAIL: user found by email " + user);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            logger.info("IN MEMORY USER DAO - FIND BY EMAIL AND PASSWORD: user found " + user);
            return Optional.of(user);
        }
        logger.warn("IN MEMORY USER DAO - FIND BY EMAIL AND PASSWORD: user with email = " + email + " or password = " + password + " not found");
        return Optional.empty();
    }
}
