package services.impl;

import entities.Student;
import repositories.Storage;
import repositories.impl.JsonStorageImpl;
import services.StudentService;

import java.util.List;
import java.util.OptionalDouble;

public class StudentServiceImpl implements StudentService<Student> {
    private final Storage<Student> storage = new JsonStorageImpl<>();

    @Override
    public void add(Student student) {
        if (student != null && !storage.contains(student)) {
            storage.add(student);
        } else {
            System.out.println("Student null or already exists");
        }
    }

    @Override
    public OptionalDouble getAverageGrade(int studentId) {
        return storage.getEntityById(studentId)
                .getGradeList()
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average();
    }

    @Override
    public List<Student> getStudents() {
        return storage.getEntities();
    }
}
