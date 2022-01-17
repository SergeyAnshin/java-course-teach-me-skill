package services.impl;

import concole.ConsoleColors;
import entities.Project;
import entities.User;
import enums.EntityServiceMessages;
import repositories.ProjectRepository;
import repositories.impl.ProjectRepositoryImpl;
import services.ProjectService;

import java.util.List;

import static enums.EntityServiceMessages.*;

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
        if (project != null && user != null) {
            if (projectRepository.transferProjectToUser(project, user)) {
                printSuccessMessageForEntity(SUCCESSFUL_TRANSFER_MESSAGE, project);
                return true;
            } else {
                printSuccessMessageForEntity(FAILED_TRANSFER_MESSAGE, project);
                return false;
            }
        } else {
            System.out.println(ConsoleColors.RED + "You try to transfer empty project " +
                    "or project recipient is empty!" + ConsoleColors.RESET);
            return false;
        }
    }
}
