package services;

import java.util.List;

public interface EntityService<T> {

    void save(T entity);

    boolean exist(T entity);

    T findById(Long id);

    boolean update(T entity);

    boolean delete(T entity);
}
