package org.sergey.ans.dao.impl.collectionstorage;

import org.sergey.ans.dao.UserDAO;
import org.sergey.ans.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public final class UserListStorage implements UserDAO {
    private final List<User> users = new ArrayList<>();

    public UserListStorage() {
        users.add(new User("mars", "ser@gmail.com", "123456", new Date(1990, Calendar.FEBRUARY, 1)));
    }

    @Override
    public boolean exists(User user) {
        return users.contains(user);
    }

    @Override
    public boolean save(User user) {
        return users.add(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
}
