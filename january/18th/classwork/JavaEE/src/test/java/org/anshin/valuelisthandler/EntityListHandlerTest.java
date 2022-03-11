package org.anshin.valuelisthandler;

import org.anshin.dao.EntityGenericDAO;
import org.anshin.dao.impl.collectionstorage.UserHashMapDAO;
import org.anshin.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ask about test method with different sorting
 */
class EntityListHandlerTest {
    private static UserHashMapDAO userStorage;
    private static EntityListHandler<User, UserHashMapDAO> userListHandler;
    private static User user1;
    private static User user2;
    private static User user3;
    private static User user4;
    private static User user5;
    private static User user6;
    private static User user7;
    private static User user8;
    private static User user9;

    @BeforeAll
    static void initUserStorage() {
        userStorage = new UserHashMapDAO();

        user1 = new User(1, "bob@gmail.com", "bob");
        user2 = new User(2, "tom@gmail.com", "tom");
        user3 = new User(3, "ford@gmail.com", "ford");
        user4 = new User(4, "kim@gmail.com", "kim");
        user5 = new User(5, "cat@gmail.com", "cat");
        user6 = new User(6, "dog@gmail.com", "dog");
        user7 = new User(7, "jack@gmail.com", "jack");
        user8 = new User(8, "nick@gmail.com", "nick");
        user9 = new User(9, "juli@gmail.com", "juli");

        userStorage.save(user1);
        userStorage.save(user2);
        userStorage.save(user3);
        userStorage.save(user4);
        userStorage.save(user5);
        userStorage.save(user6);
        userStorage.save(user7);
        userStorage.save(user8);
        userStorage.save(user9);
    }

    @BeforeEach
    void initUserListHandler() {
        userListHandler = new EntityListHandler<>(userStorage);
    }

    @Test
    void getSize() {
        assertEquals(0, userListHandler.getSize());
        userListHandler.getNextEntities(2);
        assertEquals(6, userListHandler.getSize());
    }

    @Test
    void getPreviousEntities() {
        userListHandler.getNextEntities(5);

        User[] expectedUserArray = {
                new User(7, "jack@gmail.com", "jack"),
                new User(3, "ford@gmail.com", "ford")
        };

        assertArrayEquals(expectedUserArray, userListHandler.getPreviousEntities(2).toArray());

        User[] expectedUserArrayTwo = {
                user6 = new User(6, "dog@gmail.com", "dog")
        };


        assertArrayEquals(expectedUserArrayTwo, userListHandler.getPreviousEntities(1).toArray());
    }

    @Test
    void getNextEntities() {
        User[] expectedUserArray = {
                new User(1, "bob@gmail.com", "bob"),
                new User(5, "cat@gmail.com", "cat"),
                new User(6, "dog@gmail.com", "dog")
        };

        assertArrayEquals(expectedUserArray, userListHandler.getNextEntities(3).toArray());

        User[] expectedUserArrayTwo = {
                new User(3, "ford@gmail.com", "ford"),
                new User(7, "jack@gmail.com", "jack")
        };

        assertArrayEquals(expectedUserArrayTwo, userListHandler.getNextEntities(2).toArray());

    }

    @Test
    void resetIndex() {
        assertNull(null, String.valueOf(userListHandler.getEntityListIterator()));
        userListHandler.getNextEntities(2);
        userListHandler.resetIndex();
        assertEquals(0, userListHandler.getEntityListIterator().nextIndex());
    }
}