package services;

import concole.ConsoleColors;
import enums.EntityServiceMessages;

import java.util.List;

public interface EntityService<T> {

    void save(T entity);

    boolean exist(T entity);

    T findById(Long id);

    boolean update(T entity);

    boolean delete(T entity);

    List<T> findAll();

    default void printSuccessMessageForEntity(EntityServiceMessages message, T entity) {
        if (EntityServiceMessages.isSuccessfulMessage(message)) {
            System.out.println(ConsoleColors.GREEN + getEntityName(entity) +
                    " " + message.getMessage() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + getEntityName(entity) +
                    " " + message.getMessage() + ConsoleColors.RESET);
        }

    }

    private String getEntityName(T entity) {
        return entity.getClass().getName().substring(9);
    }

}
