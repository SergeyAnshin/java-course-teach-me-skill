package org.sergey.ans.dao.impl.collectionstorage;

import org.sergey.ans.dao.UserDAO;
import org.sergey.ans.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public final class UserListDAO implements UserDAO {
    private final List<User> users = new ArrayList<>();

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
