package services;

import entities.users.User;
import storages.Storage;

import java.util.ArrayList;
import java.util.List;

public class UserStorageImpl implements StorageService<User> {
    private Storage<List<User>> storage = new Storage<>(new ArrayList<>());

    @Override
    public List<User> getAllStorage() {
        return storage.getStorage();
    }

    @Override
    public void addInStorage(User user) {
        storage.getStorage().add(user);
    }

    @Override
    public User getLastAddedItem() {
        return null;
    }

    @Override
    public boolean contains(User element) {
        return storage.getStorage()
                .stream()
                .anyMatch(user -> user.getLogin().equals(element.getLogin()));
    }
}
