package org.anshin.dao;

import org.anshin.entity.Entity;

import java.util.List;

public interface EntityGenericDAO<T extends Entity> {

    boolean exists(T entity);

    boolean save(T entity);

    List<T> findAll();

    boolean delete(Long id);

    List<T> findAllFromIdWithLimit(long id, long limit);
}
