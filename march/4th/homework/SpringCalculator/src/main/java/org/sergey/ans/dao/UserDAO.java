package org.sergey.ans.dao;

import org.sergey.ans.entity.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User> {

    Optional<User> findByEmail(String email);
}
