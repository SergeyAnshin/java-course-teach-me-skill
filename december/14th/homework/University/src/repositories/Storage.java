package repositories;

import java.util.List;

public interface Storage<T> {

    void add(T entity);

    List<T> getEntities();

    boolean exist(T entity);
}
