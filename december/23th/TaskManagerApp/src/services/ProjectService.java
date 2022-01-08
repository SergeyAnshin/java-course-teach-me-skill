package services;

import entities.Project;
import entities.User;

import java.util.List;

public interface ProjectService<T> extends EntityService<T> {

    List<T> findProjectsByUser(User user);

    boolean transferProjectToUser(T project, User user);
}
