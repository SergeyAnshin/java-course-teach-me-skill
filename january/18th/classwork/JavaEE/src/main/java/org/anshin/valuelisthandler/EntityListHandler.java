package org.anshin.valuelisthandler;

import org.anshin.entity.Entity;
import org.anshin.dao.EntityGenericDAO;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityListHandler<T extends Entity, DAO extends EntityGenericDAO<T>> implements EntityListIterator<T> {
    private static final int LOAD_FACTOR = 3;
    private DAO entityDAO;
    private CopyOnWriteArrayList<T> entities;
    private ListIterator<T> entityListIterator;
    private long lastReadId = 1;

    public EntityListHandler(DAO entityDAO) {
        this.entityDAO = entityDAO;
    }

    public ListIterator<T> getEntityListIterator() {
        return entityListIterator;
    }

    @Override
    public int getSize() {
        if (entities != null) {
            return entities.size();
        } else {
            return 0;
        }
    }

    @Override
    public List<T> getPreviousEntities(int numberEntities) {
        List<T> previousEntities;
        if (numberEntities > 0 && entities != null && entityListIterator != null) {
            previousEntities = new ArrayList<>();
            while (entityListIterator.hasPrevious() && numberEntities != 0) {
                previousEntities.add(entityListIterator.previous());
                numberEntities--;
            }
            return previousEntities;
        } else {
            throw new EntityListHandlerException();
        }
    }

    @Override
    public List<T> getNextEntities(int numberEntities) {
        if (entities == null) {
            entities = new CopyOnWriteArrayList<>( entityDAO.findAllFromIdWithLimit(lastReadId, (long) numberEntities * LOAD_FACTOR));
            entityListIterator = entities != null ? entities.listIterator() : null;
        } else {
            if (!entityListIterator.hasNext()) {
                entities.addAll(entityDAO.findAllFromIdWithLimit(lastReadId, (long) numberEntities * LOAD_FACTOR));
            }
        }


        List<T> nextEntities;
        if (numberEntities > 0 && entities != null && entityListIterator != null) {
            nextEntities = new ArrayList<>();
            T entity = null;
            while (entityListIterator.hasNext() && numberEntities != 0) {
                entity = entityListIterator.next();
                nextEntities.add(entity);
                numberEntities--;
            }
            lastReadId = entity != null ? entity.getId() : lastReadId;
            return nextEntities;
        } else {
            throw new EntityListHandlerException();
        }
    }

    @Override
    public void resetIndex() {
        if (entityListIterator != null && entities != null) {
            entityListIterator = entities.listIterator();
        }
    }
}
