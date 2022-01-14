package concole.impl;

import concole.ConsoleEntityManager;
import entities.TaskCategory;
import validators.TaskCategoryValidator;

public class ConsoleTaskCategoryManagerImpl extends AbstractConsoleEntityManager<TaskCategory> implements ConsoleEntityManager<TaskCategory> {

    public ConsoleTaskCategoryManagerImpl() {
        super(new TaskCategoryValidator());
    }

    @Override
    public TaskCategory getEntity() {
        String name = getStringValueForFieldFromConsole("name");
        return new TaskCategory(name);
    }
}
