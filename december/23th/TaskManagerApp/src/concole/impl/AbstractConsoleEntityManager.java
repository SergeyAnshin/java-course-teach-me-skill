package concole.impl;

import concole.ConsoleColors;
import concole.ConsoleEntityManager;
import concole.ConsoleOperation;
import entities.Entity;
import validators.AbstractValidator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractConsoleEntityManager<T extends Entity> implements ConsoleEntityManager<T> {
    private ConsoleOperation CONSOLE_OPERATION = new ConsoleOperation();
    private AbstractValidator<T> validator;

    public AbstractConsoleEntityManager(AbstractValidator<T> validator) {
        this.validator = validator;
    }

    public String getStringValueForFieldFromConsole(String fieldName) {
        System.out.println("Enter " + fieldName + ":");
        return getValidStringField(fieldName);
    }

    public String getValidStringField(String field) {
        String value;
        while (true) {
            value = CONSOLE_OPERATION.getStringLine();
            if (validator.isValidValueForField(value, field)) {
                return value;
            } else {
                System.out.println(validator.getErrorMessage());
            }
        }
    }

    public T selectEntityFromListById(List<T> entities) {
        if (entities != null && !entities.isEmpty()) {
            Map<Long, T> idEntityMap = entities.stream().collect(Collectors.toMap(Entity::getId, Function.identity()));
            System.out.println("Enter " + Entity.getEntityName(entities.get(0)) +  " ID:");
            while (true) {
                long selectedId = CONSOLE_OPERATION.getNumberFromTo(0, Long.MAX_VALUE);
                if (idEntityMap.containsKey(selectedId)) {
                    return idEntityMap.get(selectedId);
                }
                System.out.println(ConsoleColors.RED + "The " + Entity.getEntityName(entities.get(0)) + " with this ID doesn't exist" +
                        ConsoleColors.RESET);
            }
        }
        return null;
    }

    @Override
    public void printEntityInfo(T entity) {
        String entityName = Entity.getEntityName(entity);
        System.out.println(entityName + " ID - " + entity.getId() + ", " +
                entityName.toLowerCase() + " name - " + entity.getName());
    }

    @Override
    public void printEntityInfo(List<T> entities) {
        if (entities != null && !entities.isEmpty()) {
            entities.forEach(this::printEntityInfo);
        }
    }
}
