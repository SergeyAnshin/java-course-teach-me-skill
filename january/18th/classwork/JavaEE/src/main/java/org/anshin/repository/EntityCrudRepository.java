package org.anshin.repository;

import org.anshin.entity.Entity;

import java.util.List;

public interface EntityCrudRepository<T extends Entity> {

    boolean exists(T entity);

    boolean save(T entity);

    List<T> findAll();

    boolean delete(Long id);
}
