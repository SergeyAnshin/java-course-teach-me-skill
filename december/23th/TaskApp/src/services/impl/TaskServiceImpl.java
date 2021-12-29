package services.impl;

import entities.Task;
import repositories.TaskRepository;
import repositories.impl.TaskRepositoryImpl;
import services.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService<Task> {
    private final TaskRepository<Task> repository = new TaskRepositoryImpl();

    @Override
    public void save(Task task) {
        if (task != null && !exist(task)) {
            repository.save(task);
        } else {
            System.out.println("Task already exist or null");
        }
    }

    @Override
    public boolean exist(Task task) {
        if (task != null) {
            return repository.exist(task);
        }
        return true;
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }
}
