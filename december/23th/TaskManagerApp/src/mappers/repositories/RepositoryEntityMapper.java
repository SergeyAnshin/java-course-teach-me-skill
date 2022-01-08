package mappers.repositories;

import java.sql.ResultSet;
import java.util.List;

public interface RepositoryEntityMapper<T> {

    T toEntityFromResultSet(ResultSet resultSet);

    List<T> toListEntityFromResultSet(ResultSet resultSet);
}
