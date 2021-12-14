package services;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface StudentService<T> {

    void add(T student);

    OptionalDouble getAverageGrade(int studentId);

    List<T> getStudents();

    boolean exist(T student);

    Optional<T> getStudentById(int studentId);
}
