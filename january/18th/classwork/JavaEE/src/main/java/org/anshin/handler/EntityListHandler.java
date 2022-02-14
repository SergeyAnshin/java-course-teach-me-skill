package org.anshin.handler;

import org.anshin.entity.Entity;
import org.anshin.repository.EntityCrudRepository;

import java.util.*;

public class EntityListHandler<T extends Entity, R extends EntityCrudRepository<T>> implements ValueListIterator<T> {

    private R repository;
    private List<T> entities;
    private ListIterator<T> listIterator;

    public EntityListHandler(R repository) {
        this.repository = repository;
        entities = repository != null ? repository.findAll() : null;
        listIterator = entities != null ? entities.listIterator() : null;
    }

    @Override
    public int getSize() {
        int size = 0;
        if (entities != null) {
            size = entities.size();
        } else {

        }
        return size;
    }

    @Override
    public List<T> getPreviousElements(int count) {
        List<T> previousElements = null;
        if (entities != null && listIterator != null && listIterator.hasPrevious()) {
            previousElements = new ArrayList<>();
            while (listIterator.hasPrevious() && count != 0) {
                previousElements.add(listIterator.previous());
                count--;
            }
        }
        return previousElements;
    }

    @Override
    public List<T> getNextElements(int count) {
        List<T> nextElements = null;
        if (entities != null && listIterator != null && listIterator.hasNext()) {
            nextElements = new ArrayList<>();
            while (listIterator.hasNext() && count != 0) {
                nextElements.add(listIterator.next());
                count--;
            }
        }
        return nextElements;
    }

    @Override
    public void resetIndex() {
        if (listIterator != null && entities != null) {
            entities.listIterator(0);
        }
    }
}
