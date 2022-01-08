package repositories.impl;

import entities.Project;
import entities.User;
import mappers.repositories.impl.RepositoryProjectMapper;
import repositories.ProjectRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static queries.ProjectQueriesStorage.*;

/**
 * ДОПИСАТЬ АПДЭЙТ
 *
 */
public class ProjectRepositoryImpl extends AbstractEntityCrudRepositoryImpl<Project> implements ProjectRepository<Project> {

    public ProjectRepositoryImpl() {
        super(new RepositoryProjectMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY, UPDATE_QUERY, DELETE_QUERY);
    }

    @Override
    protected boolean executeSaveStatementForEntity(Project project, PreparedStatement statement) throws SQLException {
        if (project.getTaskDetailsList().isEmpty()) {
            return false;
        }
        User author = project.getTaskDetailsList().get(0).getAuthor();

        statement.setString(1, project.getName());
        statement.setString(2, project.getKey());
        statement.setLong(3, author.getId());
        return statement.execute();
    }

    @Override
    protected boolean executeExistStatementForEntity(Project project, PreparedStatement statement) throws SQLException {
        statement.setString(1, project.getName());
        statement.setString(2, project.getKey());
        return statement.executeQuery().next();
    }

    @Override
    public List<Project> findByUser(User user) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(FIND_BY_USER_QUERY,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setLong(1, user.getId());
                ResultSet resultSet = statement.executeQuery();
                return entityMapper.toListEntityFromResultSet(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(NO_CONNECTION_MESSAGE);
        }
        return Collections.emptyList();
    }

    @Override
    protected boolean executeUpdateStatementForEntity(Project project, PreparedStatement statement) throws SQLException {

        return false;
    }

    @Override
    protected boolean executeDeleteStatementForEntity(Project entity, PreparedStatement statement) {
        return false;
    }


    @Override
    public boolean transferProjectToUser(Project project, User user) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(TRANSFER_PROJECT_TO_ANOTHER_AUTHOR_QUERY);
                statement.setLong(1, user.getId());
                statement.setLong(2,project.getId());
                return !statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
