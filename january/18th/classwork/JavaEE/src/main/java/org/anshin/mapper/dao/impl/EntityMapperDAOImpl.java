package org.anshin.mapper.dao.impl;

import org.anshin.mapper.dao.EntityMapperDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class EntityMapperDAOImpl<T> implements EntityMapperDAO<T> {

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
}
