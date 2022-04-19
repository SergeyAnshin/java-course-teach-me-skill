package com.ans.serg.restsecurity.repository;

import com.ans.serg.restsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findAllByName(String name);
}
