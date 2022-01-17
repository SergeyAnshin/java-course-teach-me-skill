package mappers.repositories.impl;

import mappers.repositories.RepositoryEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryEntityMapperImpl<T> implements RepositoryEntityMapper<T> {

    @Override
    public T toEntityFromResultSet(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return getEntityFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> toListEntityFromResultSet(ResultSet resultSet) {
        List<T> entities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T entity = getEntityFromResultSet(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    protected abstract T getEntityFromResultSet(ResultSet resultSet) throws SQLException;

    protected T getEntityFromResultSetByColumnNumbers(ResultSet resultSet, int column1, int column2) throws SQLException {
        throw new UnsupportedOperationException();
    }

    protected T getEntityFromResultSetByColumnNumbers(ResultSet resultSet, int column1, int column2,
                                                      int column3) throws SQLException {
        throw new UnsupportedOperationException();
    }

    protected T getEntityFromResultSetByColumnNumbers(ResultSet resultSet, int column1, int column2,
                                                               int column3, int column4) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
