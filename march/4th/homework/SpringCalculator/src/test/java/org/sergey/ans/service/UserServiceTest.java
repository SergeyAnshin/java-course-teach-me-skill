package org.sergey.ans.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sergey.ans.dao.impl.collectionstorage.UserListDAO;
import org.sergey.ans.entity.User;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private static UserListDAO userListDAO;
    private static UserService userService;

    private static User user;
    private static User user1;
    private static User user2;

    @BeforeAll
    static void init() {
        userListDAO = new UserListDAO();
        userService = new UserService(userListDAO);
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

    @Test
    void authenticate() {
        assertEquals(Optional.of(user), userService.authenticate(user));
        assertEquals(Optional.empty(), userService.authenticate(user1));
    }
}