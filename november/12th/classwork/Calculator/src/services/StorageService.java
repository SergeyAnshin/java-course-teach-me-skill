package services;

import java.util.List;

public interface StorageService<T> {

    List<T> getAllStorage();

    void addInStorage(T elements);

    T getLastAddedItem();

    boolean contains(T element);
}
