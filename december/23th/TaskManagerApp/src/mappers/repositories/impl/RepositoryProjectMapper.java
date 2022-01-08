package mappers.repositories.impl;

import entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProjectMapper extends RepositoryEntityMapperImpl<Project>{
    private RepositoryUserMapper userMapper = new RepositoryUserMapper();
    private RepositoryTaskCategoryMapper categoryMapper = new RepositoryTaskCategoryMapper();
    private RepositoryTaskMapper taskMapper = new RepositoryTaskMapper();

    @Override
    protected Project getEntityFromResultSet(ResultSet resultSet) throws SQLException {

        Long projectId = null;
        String projectName = null;
        String projectKey = null;
        List<TaskDetails> taskDetailsList = new ArrayList<>();
        Task task;
        TaskCategory taskCategory;
        User author;
        User executor;
        while (resultSet.next()) {
            if (projectId == null) {
                projectId = resultSet.getLong(1);
                projectName = resultSet.getString(2);
                projectKey = resultSet.getString(3);
            } else {
                long currentProjectId = resultSet.getLong(1);
                if (projectId != currentProjectId) {
                    resultSet.previous();
                    return new Project(projectId, projectName, projectKey, taskDetailsList);
                }
            }

            Long taskDetailsId = resultSet.getLong(4);

            task = taskMapper.getEntityFromResultSetByColumnNumbers(resultSet,5, 6);

            taskCategory = categoryMapper.getEntityFromResultSetByColumnNumbers(resultSet,7, 8);

            task.setTaskCategory(taskCategory);

            author = userMapper.getEntityFromResultSetByColumnNumbers(resultSet, 9, 10, 11, 12);

            executor = userMapper.getEntityFromResultSetByColumnNumbers(resultSet, 13, 14, 15, 16);

            taskDetailsList.add(new TaskDetails(taskDetailsId, task, author, executor));
        }
        return new Project(projectId, projectName, projectKey, taskDetailsList);
    }
}
