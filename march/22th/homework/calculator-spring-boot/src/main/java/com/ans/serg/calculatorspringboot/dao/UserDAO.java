package com.ans.serg.calculatorspringboot.dao;

import com.ans.serg.calculatorspringboot.entity.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
