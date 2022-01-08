package services;

public interface UserService<T> extends EntityService<T> {

    T findByLoginAndPassword(String login, String password);

    T findByLogin(String login);
}
