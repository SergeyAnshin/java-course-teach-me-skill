package services.impl;

import concole.ConsoleColors;
import entities.Task;
import entities.TaskCategory;
import repositories.TaskRepository;
import repositories.impl.TaskRepositoryImpl;
import services.TaskService;

public class TaskServiceImpl extends AbstractEntityServiceImpl<Task> implements TaskService<Task> {
    private TaskRepository taskRepository = new TaskRepositoryImpl();

    public TaskServiceImpl() {
        super(new TaskRepositoryImpl());
    }

    @Override
    public boolean changeTaskCategoryForAllTaskWithCurrentCategory(TaskCategory currentTaskCategory, TaskCategory newTaskCategory) {
        if (taskRepository.changeTaskCategoryForAllTaskWithCurrentCategory(currentTaskCategory, newTaskCategory)) {
            System.out.println(ConsoleColors.GREEN + "Task category has been changed!" + ConsoleColors.RESET);
            return true;
        } else {
            System.out.println(ConsoleColors.RED + "Task category has not changed!" + ConsoleColors.RESET);
            return false;
        }
    }
}
