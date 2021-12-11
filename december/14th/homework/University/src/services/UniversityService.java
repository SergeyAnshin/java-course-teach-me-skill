package services;

import java.util.List;
import java.util.OptionalDouble;

public interface UniversityService<T> {

    void add(T university);

    OptionalDouble getAverageGrade(int universityId);

    List<T> getUniversities();
}
