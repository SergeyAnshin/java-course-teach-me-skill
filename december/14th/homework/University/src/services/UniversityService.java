package services;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface UniversityService<T> {

    void add(T university);

    OptionalDouble getAverageGrade(int universityId);

    List<T> getUniversities();

    boolean exist(T university);

    Optional<T> getUniversityById(int universityId);
}
