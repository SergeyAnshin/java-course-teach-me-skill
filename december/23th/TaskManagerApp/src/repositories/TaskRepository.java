package repositories;

import entities.TaskCategory;

public interface TaskRepository<T> extends CrudRepository<T> {

    boolean changeTaskCategoryForAllTaskWithCurrentCategory(TaskCategory currentTaskCategory, TaskCategory newTaskCategory);
}
