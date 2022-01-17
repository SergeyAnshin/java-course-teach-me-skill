package concole.impl;

import concole.ConsoleEntityManager;
import entities.Task;
import entities.TaskCategory;
import validators.TaskValidator;

public class ConsoleTaskManagerImpl extends AbstractConsoleEntityManager<Task> implements ConsoleEntityManager<Task> {
    private ConsoleTaskCategoryManagerImpl taskCategoryManager = new ConsoleTaskCategoryManagerImpl();

    public ConsoleTaskManagerImpl() {
        super(new TaskValidator());
    }

    @Override
    public Task getEntity() {
        String name = getStringValueForFieldFromConsole("name");
        TaskCategory taskCategory = taskCategoryManager.selectTaskCategoryFromDB();
        return new Task(name, taskCategory);
    }


}
