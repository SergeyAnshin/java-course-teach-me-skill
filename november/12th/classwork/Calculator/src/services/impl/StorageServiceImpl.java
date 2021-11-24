package services.impl;

import services.StorageService;
import storages.Storage;

import java.util.ArrayList;
import java.util.List;

public class StorageServiceImpl implements StorageService<Double> {
    private Storage<List<Double>> storage = new Storage<>(new ArrayList<>());
    private int indexToAddCalculationResult = 0;
    private int maxIndexToAdd = 5;

    @Override
    public List<Double> getAllStorage() {
        return storage.getStorage();
    }


    @Override
    public void addInStorage(Double element) {
        if (indexToAddCalculationResult >= maxIndexToAdd) {
            indexToAddCalculationResult = 0;
        }
        storage.getStorage().add(indexToAddCalculationResult, element);
        indexToAddCalculationResult++;
    }

    @Override
    public Double getLastAddedItem() {
        return storage.getStorage().get(indexToAddCalculationResult - 1);
    }

    @Override
    public boolean contains(Double element) {
        return storage.getStorage().contains(element);
    }


}
