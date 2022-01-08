package services.impl;

import entities.TaskDetails;
import repositories.TaskDetailsRepository;
import repositories.impl.TaskDetailsRepositoryImpl;
import services.TaskDetailsService;

public class TaskDetailsServiceImpl extends AbstractEntityServiceImpl<TaskDetails> implements TaskDetailsService<TaskDetails> {
    private TaskDetailsRepository<TaskDetails> taskDetailsRepository = new TaskDetailsRepositoryImpl();

    public TaskDetailsServiceImpl() {
        super(new TaskDetailsRepositoryImpl());
    }
}
