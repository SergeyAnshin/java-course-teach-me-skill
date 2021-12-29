package services.impl;

import entities.TaskCategory;
import repositories.TaskCategoryRepository;
import repositories.impl.TaskCategoryRepositoryImpl;
import services.TaskCategoryService;

import java.util.List;

public class TaskCategoryServiceImpl implements TaskCategoryService<TaskCategory> {
    private final TaskCategoryRepository<TaskCategory> repository = new TaskCategoryRepositoryImpl();

    @Override
    public void save(TaskCategory taskCategory) {
        if (taskCategory != null && !exist(taskCategory)) {
            repository.save(taskCategory);
        } else {
            System.out.println("TaskCategory already exist or null");
        }
    }

    @Override
    public boolean exist(TaskCategory taskCategory) {
        if (taskCategory != null) {
            return repository.exist(taskCategory);
        }
        return true;
    }

    @Override
    public List<TaskCategory> findAll() {
        return repository.findAll();
    }
}
