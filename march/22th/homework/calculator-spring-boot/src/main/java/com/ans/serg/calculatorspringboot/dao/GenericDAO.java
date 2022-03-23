package com.ans.serg.calculatorspringboot.dao;

import com.ans.serg.calculatorspringboot.entity.Entity;

public interface GenericDAO<T extends Entity> {

    boolean exists(T entity);

    boolean save(T entity);
}
