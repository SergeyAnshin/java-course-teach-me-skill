package services;

import java.util.List;
import java.util.OptionalDouble;

public interface StudentService<T> {

    void add(T student);

    OptionalDouble getAverageGrade(int studentId);

    List<T> getStudents();
}
