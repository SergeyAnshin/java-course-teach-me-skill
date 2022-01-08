package services.impl;

import entities.Project;
import entities.User;
import repositories.ProjectRepository;
import repositories.impl.ProjectRepositoryImpl;
import services.ProjectService;

import java.util.List;

public class ProjectServiceImpl extends AbstractEntityServiceImpl<Project> implements ProjectService<Project> {
    private ProjectRepository<Project> projectRepository = new ProjectRepositoryImpl();

    public ProjectServiceImpl() {
        super(new ProjectRepositoryImpl());
    }

    @Override
    public List<Project> findProjectsByUser(User user) {
        return projectRepository.findByUser(user);
    }

    @Override
    public boolean transferProjectToUser(Project project, User user) {
        return projectRepository.transferProjectToUser(project, user);
    }
}
