package services.impl;

import entities.Student;
import repositories.Storage;
import repositories.impl.JsonFileStorageImpl;
import services.StudentService;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StudentServiceImpl implements StudentService<Student> {
    private final Storage<Student> storage =
            new JsonFileStorageImpl<>(new File("students.txt"),Student.class);

    @Override
    public void add(Student student) {
        if (student != null && !exist(student)) {
            storage.add(student);
        } else {
            System.out.println("Student null or already exists");
        }
    }

    @Override
    public OptionalDouble getAverageGrade(int studentId) {
        Optional<Student> student = getStudentById(studentId);
        if (student.isPresent()) {
            return student.get()
                    .getGradeList()
                    .stream()
                    .mapToDouble(Integer::doubleValue)
                    .average();
        } else {
            return OptionalDouble.of(0);
        }
    }

    @Override
    public List<Student> getStudents() {
        return storage.getEntities();
    }

    @Override
    public boolean exist(Student student) {
        return getStudents()
                .stream()
                .anyMatch(student1 -> student1.equals(student));
    }

    @Override
    public Optional<Student> getStudentById(int studentId) {
        return getStudents()
                .stream()
                .filter(student -> student.getId() == studentId)
                .findFirst();
    }
}
