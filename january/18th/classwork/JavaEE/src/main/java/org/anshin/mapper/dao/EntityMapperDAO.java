package org.anshin.mapper.dao;

import java.sql.ResultSet;
import java.util.List;

public interface EntityMapperDAO<T> {

    T toEntityFromResultSet(ResultSet resultSet);

    List<T> toListEntityFromResultSet(ResultSet resultSet);
}
