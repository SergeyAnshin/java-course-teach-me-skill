package org.sergey.ans.service;

import org.sergey.ans.dao.UserDAO;
import org.sergey.ans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier(value = "jpaUserDAO") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean save(User user) {
        if (userDAO.exists(user)) {
            return false;
        } else {
            return userDAO.save(user);
        }
    }

    public Optional<User> authenticate(User user) {
        Optional<User> authUser = userDAO.findByEmail(user.getEmail());
        if (authUser.isPresent() && authUser.get().getPassword().equals(user.getPassword())) {
            return authUser;
        } else {
            return Optional.empty();
        }
    }
}
