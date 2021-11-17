package storages;

public class Storage<T> {
    private T storage;

    public Storage(T storage) {
        this.storage = storage;
    }

    public T getStorage() {
        return storage;
    }

    public void setStorage(T storage) {
        this.storage = storage;
    }

}
