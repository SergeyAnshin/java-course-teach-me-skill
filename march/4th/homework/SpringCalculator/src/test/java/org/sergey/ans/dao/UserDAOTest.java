package org.sergey.ans.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sergey.ans.entity.User;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private static UserDAO userDAO;

    private static User user;
    private static User user1;
    private static User user2;
    private static User user3;

    @BeforeAll
    static void init() {
        userDAO = new UserDAO();
        user = new User("Tom", "tom@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(25)));
        user1 = new User("Tom", "tom@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(25)));
        user2 = new User("Bob", "bob@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(22)));
        user3 = new User("Hope", "hope@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(24)));
    }

    @Test
    void exists() {
        userDAO.save(user);
        userDAO.save(user1);
        userDAO.save(user2);

        assertTrue(userDAO.exists(user));
        assertTrue(userDAO.exists(user1));
        assertTrue(userDAO.exists(user2));
        assertFalse(userDAO.exists(user3));
    }

    @Test
    void save() {
        assertTrue(userDAO.save(user));
        assertTrue(userDAO.save(user1));
        assertTrue(userDAO.save(user2));
    }

    @Test
    void findAll() {
        assertEquals(3, userDAO.findAll().size());
    }
}