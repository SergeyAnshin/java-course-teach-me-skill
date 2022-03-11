package org.anshin.valuelisthandler;

import java.util.List;

public interface EntityListIterator<T> {

    int getSize();

    List<T> getPreviousEntities(int numberEntities);

    List<T> getNextEntities(int numberEntities);

    void resetIndex();
}
