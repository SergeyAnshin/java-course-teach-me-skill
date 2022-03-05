package org.sergey.ans.service;

import org.sergey.ans.dao.GenericDAO;
import org.sergey.ans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class UserService {
    private final GenericDAO<User> userDAO;

    @Autowired
    public UserService(GenericDAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    public boolean save(User user) {
        if (!userDAO.exists(user)) {
            return userDAO.save(user);
        } else {
            return false;
        }
    }
}
