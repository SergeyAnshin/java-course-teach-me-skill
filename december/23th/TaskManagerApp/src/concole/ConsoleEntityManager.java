package concole;

import java.util.List;

public interface ConsoleEntityManager<T> {

    T getEntity();

    String getStringValueForFieldFromConsole(String fieldName);

    String getValidStringField(String field);

    T selectEntityFromListById(List<T> entities);
}
