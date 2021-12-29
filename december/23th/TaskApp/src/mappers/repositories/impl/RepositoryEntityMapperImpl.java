package mappers.repositories.impl;

import mappers.repositories.RepositoryEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryEntityMapperImpl<T> implements RepositoryEntityMapper<T> {

    @Override
    public T fromResultSetToEntity(ResultSet resultSet) {
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
    public List<T> fromResultSetToListEntity(ResultSet resultSet) {
        List<T> entities = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            T entity = getEntityFromResultSet(resultSet);
            entities.add(entity);
        }
        return entities;
    }

    protected abstract T getEntityFromResultSet(ResultSet resultSet);

    protected T fromResultSetToEntityByColumnIndex(ResultSet resultSet, int index1, int index2) {
        throw new UnsupportedOperationException();
    }

    protected T fromResultSetToEntityByColumnIndex(ResultSet resultSet, int index1, int index2,
                                           int index3, int index4) {
        throw new UnsupportedOperationException();
    }
}
