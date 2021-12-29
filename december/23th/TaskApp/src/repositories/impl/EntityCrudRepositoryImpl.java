package repositories.impl;

import connections.DBConnector;
import mappers.repositories.RepositoryEntityMapper;
import repositories.CrudRepository;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public abstract class EntityCrudRepositoryImpl<T> implements CrudRepository<T> {
    private final Connection connection = DBConnector.getInstance().getConnection();
    private static final String NO_CONNECTION_MESSAGE = "No connection to the database";
    protected RepositoryEntityMapper<T> entityMapper;
    private String saveQuery;
    private String existQuery;
    private String findAllQuery;
    private String findByIdQuery;

    public EntityCrudRepositoryImpl() {
    }

    public EntityCrudRepositoryImpl(RepositoryEntityMapper<T> entityMapper, String saveQuery, String existQuery,
                                    String findAllQuery, String findByIdQuery) {
        this.entityMapper = entityMapper;
        this.saveQuery = saveQuery;
        this.existQuery = existQuery;
        this.findAllQuery = findAllQuery;
        this.findByIdQuery = findByIdQuery;
    }

    @Override
    public void save(T entity) {
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(saveQuery);
                executeSaveStatementForEntity(entity, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(NO_CONNECTION_MESSAGE);
        }
    }

    protected abstract void executeSaveStatementForEntity(T entity, PreparedStatement statement) throws SQLException;

    @Override
    public boolean exist(T entity) {
        boolean exist = true;
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(existQuery);
                exist = executeExistStatementForEntity(entity, statement).next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(NO_CONNECTION_MESSAGE);
        }
        return exist;
    }

    protected abstract ResultSet executeExistStatementForEntity(T entity, PreparedStatement statement) throws SQLException;

    @Override
    public List<T> findAll() {
        if (connection != null) {
            List<T> entities = Collections.emptyList();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(findAllQuery);
                entities = getListEntitiesFromResultSet(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return entities;
        } else {
            return Collections.emptyList();
        }
    }

    protected abstract List<T> getListEntitiesFromResultSet(ResultSet resultSet);

    @Override
    public T findById(Long id) {
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(findByIdQuery);
                statement.setLong(1, id);
                ResultSet resultSet = statement.executeQuery();
                return getEntityFromResultSet(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected abstract T getEntityFromResultSet(ResultSet resultSet);
}
