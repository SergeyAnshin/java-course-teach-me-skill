package services.impl;

import entities.Task;
import repositories.impl.TaskRepositoryImpl;
import services.TaskService;

public class TaskServiceImpl extends AbstractEntityServiceImpl<Task> implements TaskService<Task> {

    public TaskServiceImpl() {
        super(new TaskRepositoryImpl());
    }
}
