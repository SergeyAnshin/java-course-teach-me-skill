package org.anshin.handler;

import java.util.List;

public interface ValueListIterator<T> {

    int getSize();

    List<T> getPreviousElements(int count);

    List<T> getNextElements(int count);

    void resetIndex();
}
