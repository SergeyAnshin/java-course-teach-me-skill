package services.impl;

import entities.TaskCategory;
import repositories.TaskCategoryRepository;
import repositories.impl.TaskCategoryRepositoryImpl;
import services.TaskCategoryService;

public class TaskCategoryServiceImpl extends AbstractEntityServiceImpl<TaskCategory> implements TaskCategoryService<TaskCategory> {
    private TaskCategoryRepository<TaskCategory> taskCategoryRepository = new TaskCategoryRepositoryImpl();

    public TaskCategoryServiceImpl() {
        super(new TaskCategoryRepositoryImpl());
    }

}
