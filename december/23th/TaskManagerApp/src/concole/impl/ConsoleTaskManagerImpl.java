package concole.impl;

import concole.ConsoleEntityManager;
import entities.Task;
import validators.TaskValidator;

public class ConsoleTaskManagerImpl extends AbstractConsoleEntityManager<Task> implements ConsoleEntityManager<Task> {

    public ConsoleTaskManagerImpl() {
        super(new TaskValidator());
    }

    @Override
    public Task getEntity() {
        String name = getStringValueForFieldFromConsole("name");
        return new Task(name);
    }
}
