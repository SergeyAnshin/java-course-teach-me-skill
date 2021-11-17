package storages;

public class UserStorage<T> {
    private T userStorage;

    public UserStorage(T userStorage) {
        this.userStorage = userStorage;
    }

    public T getUserStorage() {
        return userStorage;
    }

    public void setUserStorage(T userStorage) {
        this.userStorage = userStorage;
    }
}
