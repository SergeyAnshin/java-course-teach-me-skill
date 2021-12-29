package mappers.repositories.impl;

import entities.Task;
import entities.TaskCategory;
import entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryTaskMapper extends RepositoryEntityMapperImpl<Task> {
    private RepositoryEntityMapperImpl<User> userMapper =  new RepositoryUserMapper();
    private RepositoryEntityMapperImpl<TaskCategory> taskCategoryMapper = new RepositoryTaskCategoryMapper();

    @Override
    protected Task getEntityFromResultSet(ResultSet resultSet) {
        try {
            Long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            TaskCategory taskCategory = taskCategoryMapper.fromResultSetToEntityByColumnIndex(resultSet, 3, 4);
            User author = userMapper.fromResultSetToEntityByColumnIndex(resultSet, 5, 6, 7, 8);
            User executor = userMapper.fromResultSetToEntityByColumnIndex(resultSet, 9, 10, 11, 12);
            return new Task(id,name,taskCategory, author, executor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Task fromResultSetToEntityByColumnIndex(ResultSet resultSet, int index1, int index2) {
        try {
            Long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            return new Task(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected Task fromResultSetToEntityByColumnIndex(ResultSet resultSet, int indexIdColumn, int indexNameColumn,
                                                      int indexTaskCategoryIdColumn, int indexTaskCategoryNameColumn) {
        try {
            Long id = resultSet.getLong(indexIdColumn);
            String name = resultSet.getString(indexNameColumn);
            TaskCategory taskCategory = taskCategoryMapper.fromResultSetToEntityByColumnIndex(resultSet,
                    indexTaskCategoryIdColumn, indexTaskCategoryNameColumn);
            return new Task(id, name, taskCategory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
