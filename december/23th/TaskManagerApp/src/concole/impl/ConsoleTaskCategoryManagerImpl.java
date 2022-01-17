package concole.impl;

import concole.ConsoleEntityManager;
import entities.TaskCategory;
import services.TaskCategoryService;
import services.impl.TaskCategoryServiceImpl;
import validators.TaskCategoryValidator;

import java.util.List;

public class ConsoleTaskCategoryManagerImpl extends AbstractConsoleEntityManager<TaskCategory> implements ConsoleEntityManager<TaskCategory> {
    public static final TaskCategoryService<TaskCategory> TASK_CATEGORY_SERVICE = new TaskCategoryServiceImpl();

    public ConsoleTaskCategoryManagerImpl() {
        super(new TaskCategoryValidator());
    }

    @Override
    public TaskCategory getEntity() {
        String name = getStringValueForFieldFromConsole("name");
        return new TaskCategory(name);
    }

    public TaskCategory selectTaskCategoryFromDB() {
        System.out.println("\nChoose one of the categories:");
        List<TaskCategory> taskCategories = TASK_CATEGORY_SERVICE.findAll();
        printEntityInfo(taskCategories);
        return selectEntityFromListById(taskCategories);
    }
}
