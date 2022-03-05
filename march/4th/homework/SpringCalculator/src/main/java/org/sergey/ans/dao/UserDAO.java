package org.sergey.ans.dao;

import org.sergey.ans.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public final class UserDAO implements GenericDAO<User>  {
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
}
