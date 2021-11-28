public class Account<T, R> {
    private T id;
    private R login;

    public Account(T id, R login) {
        this.id = id;
        this.login = login;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public <Z, E> void print(Z info, E user) {

    }
}
