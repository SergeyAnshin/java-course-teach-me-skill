package org.sergey.ans.dao.impl.collectionstorage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sergey.ans.entity.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserListStorageTest {
    private static UserListStorage userListStorage;

    private static User user;
    private static User user1;
    private static User user2;
    private static User user3;

    @BeforeAll
    static void init() {
        userListStorage = new UserListStorage();
        user = new User("Tom", "tom@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(25)));
        user1 = new User("Tom", "tom@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(25)));
        user2 = new User("Bob", "bob@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(22)));
        user3 = new User("Hope", "hope@gmail.com", "12345", Date.valueOf(LocalDate.now().minusYears(24)));
    }

    @Test
    void exists() {
        userListStorage.save(user);
        userListStorage.save(user1);
        userListStorage.save(user2);

        assertTrue(userListStorage.exists(user));
        assertTrue(userListStorage.exists(user1));
        assertTrue(userListStorage.exists(user2));
        assertFalse(userListStorage.exists(user3));
    }

    @Test
    void save() {
        assertTrue(userListStorage.save(user));
        assertTrue(userListStorage.save(user1));
        assertTrue(userListStorage.save(user2));
    }

    @Test
    void findAll() {
        assertArrayEquals(new User[] {user, user1, user2}, userListStorage.findAll().toArray());
    }

    @Test
    void findByEmail() {
        assertEquals(Optional.of(user), userListStorage.findByEmail("tom@gmail.com"));
        assertEquals(Optional.empty(), userListStorage.findByEmail("liza@gmail.com"));
    }
}