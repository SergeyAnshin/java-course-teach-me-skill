package org.anshin.service.impl;

import org.anshin.dao.UserDAO;
import org.anshin.dao.impl.collectionstorage.UserHashMapDAO;
import org.anshin.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private static UserDAO userDAO;
    private static UserService userService;

    @BeforeAll
    static void init() {
        userDAO = new UserHashMapDAO();
        userService = new UserServiceImpl(userDAO);
    }

    @Test
    void exists() {
    }

    @Test
    void existsByEmailOrLogin() {
    }

    @Test
    void save() {
    }

    @Test
    void findByLogin() {
    }

    @Test
    void findByLoginAndPassword() {
    }

    @Test
    void findAll() {
    }

    @Test
    void updatePasswordForUserWithEmail() {
    }

    @Test
    void existsByEmailAndKeyword() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }
}