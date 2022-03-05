package org.sergey.ans.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sergey.ans.dao.UserDAO;
import org.sergey.ans.entity.User;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private static UserDAO userDAO;
    private static UserService userService;

    private static User user;
    private static User user1;
    private static User user2;

    @BeforeAll
    static void init() {
        userDAO = new UserDAO();
        userService = new UserService(userDAO);
        user = new User("Tom", "tom@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(25)));
        user1 = new User("Tom", "tom@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(25)));
        user2 = new User("Bob", "bob@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(22)));
    }

    @Test
    void save() {
        assertTrue(userService.save(user));
        assertFalse(userService.save(user1));
        assertTrue(userService.save(user2));
    }
}