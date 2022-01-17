package repositories.impl;

import concole.ConsoleColors;
import connections.TaskManagerAppDBConnector;
import mappers.repositories.RepositoryEntityMapper;
import repositories.CrudRepository;

import java.sql.*;
import java.util.List;

public abstract class AbstractEntityCrudRepositoryImpl<T> implements CrudRepository<T> {
    public static final Connection CONNECTION = TaskManagerAppDBConnector.getInstance().getConnection();
    public static final String NO_CONNECTION_MESSAGE = ConsoleColors.RED + "No connection to the database" + ConsoleColors.RESET;
    protected RepositoryEntityMapper<T> entityMapper;
    private String saveQuery;
    private String existQuery;
    private String findAllQuery;
    private String findByIdQuery;
    private String updateQuery;
    private String deleteQuery;

    public AbstractEntityCrudRepositoryImpl(RepositoryEntityMapper<T> entityMapper, String saveQuery, 
                                            String existQuery, String findAllQuery, String findByIdQuery, 
                                            String updateQuery, String deleteQuery) {
        this.entityMapper = entityMapper;
        this.saveQuery = saveQuery;
        this.existQuery = existQuery;
        this.findAllQuery = findAllQuery;
        this.findByIdQuery = findByIdQuery;
        this.updateQuery = updateQuery;
        this.deleteQuery = deleteQuery;
    }

    @Override
    public boolean save(T entity) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(saveQuery);
                return executeSaveStatementForEntity(entity, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(NO_CONNECTION_MESSAGE);
        }
        return false;
    }

    protected abstract boolean executeSaveStatementForEntity(T entity, PreparedStatement statement) throws SQLException;

    @Override
    public boolean exist(T entity) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(existQuery);
                return executeExistStatementForEntity(entity, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(NO_CONNECTION_MESSAGE);
        }
        return false;
    }

    protected abstract boolean executeExistStatementForEntity(T entity, PreparedStatement statement) throws SQLException;

    @Override
    public T findById(Long id) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(findByIdQuery,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                statement.setLong(1, id);
                ResultSet resultSet = statement.executeQuery();
                return entityMapper.toEntityFromResultSet(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public boolean update(T entity) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(updateQuery);
                return executeUpdateStatementForEntity(entity, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    protected abstract boolean executeUpdateStatementForEntity(T entity, PreparedStatement statement) throws SQLException;


    @Override
    public boolean delete(T entity) {
        if (CONNECTION != null) {
            try {
                PreparedStatement statement = CONNECTION.prepareStatement(deleteQuery);
                return executeDeleteStatementForEntity(entity, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    protected abstract boolean executeDeleteStatementForEntity(T entity, PreparedStatement statement) throws SQLException;

    @Override
    public List<T> findAll() {
        if (CONNECTION != null) {
            try {
                PreparedStatement preparedStatement = CONNECTION.prepareStatement(findAllQuery,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                return entityMapper.toListEntityFromResultSet(preparedStatement.executeQuery());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
