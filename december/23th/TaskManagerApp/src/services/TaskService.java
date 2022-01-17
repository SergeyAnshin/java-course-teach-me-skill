package services;

import entities.TaskCategory;

public interface TaskService<T> extends EntityService<T> {

    boolean changeTaskCategoryForAllTaskWithCurrentCategory(TaskCategory currentTaskCategory, TaskCategory newTaskCategory);
}
