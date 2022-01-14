package repositories.impl;

import entities.Project;
import entities.Task;
import mappers.repositories.RepositoryEntityMapper;
import mappers.repositories.impl.RepositoryTaskMapper;
import repositories.ProjectRepository;
import repositories.TaskRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static queries.TaskQueriesStorage.*;
public class TaskRepositoryImpl extends AbstractEntityCrudRepositoryImpl<Task> implements TaskRepository<Task> {

    public TaskRepositoryImpl() {
        super(new RepositoryTaskMapper(), SAVE_QUERY, EXIST_QUERY, FIND_ALL_QUERY, FIND_BY_ID_QUERY,
                UPDATE_QUERY, DELETE_QUERY);
    }

    @Override
    protected boolean executeSaveStatementForEntity(Task task, PreparedStatement statement) throws SQLException {
        statement.setString(1, task.getName());
        statement.setLong(2, task.getTaskCategory().getId());
        statement.setLong(3, task.getTaskDetails().getProject().getId());
        statement.setLong(4, task.getTaskDetails().getAuthor().getId());
        return statement.execute();
    }

    @Override
    protected boolean executeExistStatementForEntity(Task task, PreparedStatement statement) throws SQLException {
        return false;
    }

    @Override
    protected boolean executeUpdateStatementForEntity(Task task, PreparedStatement statement) throws SQLException {
        return false;
    }

    @Override
    protected boolean executeDeleteStatementForEntity(Task task, PreparedStatement statement) throws SQLException {
        statement.setLong(1, task.getId());
        return statement.executeUpdate() != 0;
    }
}
