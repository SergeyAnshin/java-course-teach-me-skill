package mappers.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RepositoryEntityMapper<T> {

    T fromResultSetToEntity(ResultSet resultSet);

    List<T> fromResultSetToListEntity(ResultSet resultSet);
}
