package com.ans.serg.calculatorrestproject.repository;

import com.ans.serg.calculatorrestproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);
}
