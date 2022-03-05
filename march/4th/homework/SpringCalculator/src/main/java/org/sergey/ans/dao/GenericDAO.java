package org.sergey.ans.dao;

import java.util.List;

public interface GenericDAO<T> {

    boolean exists(T entity);

    boolean save(T entity);

    List<T> findAll();
}
