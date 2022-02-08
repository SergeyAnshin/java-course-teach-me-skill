package org.anshin.repository;

import org.anshin.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {

    boolean exists(String email, String login);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);

    boolean updatePasswordForUserWithEmail(String newPassword, String email);

    boolean existsByEmailAndKeyword(String email, String keyword);

    boolean update(User user);

    Optional<User> findById(Long id);
}
