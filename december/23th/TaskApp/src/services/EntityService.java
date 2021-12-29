package services;

import java.util.List;

public interface EntityService<T> {

    void save(T entity);

    boolean exist(T entity);

    List<T> findAll();
}
