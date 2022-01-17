package concole.impl;

import concole.ConsoleEntityManager;
import entities.Task;
import entities.TaskCategory;
import services.TaskCategoryService;
import services.impl.TaskCategoryServiceImpl;
import validators.TaskValidator;

import java.util.List;

public class ConsoleTaskManagerImpl extends AbstractConsoleEntityManager<Task> implements ConsoleEntityManager<Task> {
    public static final TaskCategoryService<TaskCategory> TASK_CATEGORY_SERVICE = new TaskCategoryServiceImpl();

    public ConsoleTaskManagerImpl() {
        super(new TaskValidator());
    }

    @Override
    public Task getEntity() {
        String name = getStringValueForFieldFromConsole("name");
        TaskCategory taskCategory = getTaskCategory();
        return new Task(name, taskCategory);
    }

    private TaskCategory getTaskCategory() {
        System.out.println("\nChoose one of the categories:");
        List<TaskCategory> taskCategories = TASK_CATEGORY_SERVICE.findAll();
        ConsoleEntityManager<TaskCategory> categoryConsoleEntityManager = new ConsoleTaskCategoryManagerImpl();
        categoryConsoleEntityManager.printEntityInfo(taskCategories);
        return categoryConsoleEntityManager.selectEntityFromListById(taskCategories);
    }
}
