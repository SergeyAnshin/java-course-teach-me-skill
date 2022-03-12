package org.sergey.ans.dao.impl.collectionstorage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.sergey.ans.entity.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserListDAOTest {
    private static UserListDAO userListDAO;

    private static User user;
    private static User user1;
    private static User user2;
    private static User user3;

    @BeforeAll
    static void init() {
        userListDAO = new UserListDAO();
        user = new User("Tom", "tom@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(25)));
        user1 = new User("Tom", "tom@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(25)));
        user2 = new User("Bob", "bob@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(22)));
        user3 = new User("Hope", "hope@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(24)));
    }

    @Test
    void exists() {
        userListDAO.save(user);
        userListDAO.save(user1);
        userListDAO.save(user2);

        assertTrue(userListDAO.exists(user));
        assertTrue(userListDAO.exists(user1));
        assertTrue(userListDAO.exists(user2));
        assertFalse(userListDAO.exists(user3));
    }

    @Test
    void save() {
        assertTrue(userListDAO.save(user));
        assertTrue(userListDAO.save(user1));
        assertTrue(userListDAO.save(user2));
    }

    @Test
    void findAll() {
        assertArrayEquals(new User[] {user, user1, user2}, userListDAO.findAll().toArray());
    }

    @Test
    void findByEmail() {
        assertEquals(Optional.of(user), userListDAO.findByEmail("tom@gmail.com"));
        assertEquals(Optional.empty(), userListDAO.findByEmail("liza@gmail.com"));
    }
}