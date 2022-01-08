package repositories;

public interface UserRepository<T> extends CrudRepository<T> {

    T findByLoginAndPassword(String login, String password);

    T findByLogin(String login);
}
