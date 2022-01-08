package repositories;

import entities.User;

import java.util.List;

public interface ProjectRepository<T> extends CrudRepository<T> {

    List<T> findByUser(User user);

    boolean transferProjectToUser(T project, User user);
}
