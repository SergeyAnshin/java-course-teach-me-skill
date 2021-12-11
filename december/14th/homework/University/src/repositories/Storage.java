package repositories;

import java.util.List;

public interface Storage<T> {

    void add(T entity);

    T getEntityById(int entityId);

    List<T> getEntities();

    boolean contains(T entity);
}
