package services;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface GroupService<T> {

    void add(T group);

    OptionalDouble getAverageGrade(int groupId);

    List<T> getGroups();

    Optional<T> getGroupById(int groupId);

    boolean exist(T group);

}
