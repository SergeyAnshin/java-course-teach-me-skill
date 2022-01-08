package repositories;

import java.util.List;

public interface CrudRepository<T> {

    boolean save(T entity);

    boolean exist(T entity);
//
//    List<T> findAll();
//
    T findById(Long id);

    boolean update(T entity);

    boolean delete(T entity);
}
