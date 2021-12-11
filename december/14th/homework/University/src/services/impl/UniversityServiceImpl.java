package services.impl;

import entities.Group;
import entities.Student;
import entities.University;
import repositories.Storage;
import repositories.impl.JsonStorageImpl;
import services.UniversityService;

import java.util.List;
import java.util.OptionalDouble;

public class UniversityServiceImpl implements UniversityService<University> {
    private final Storage<University> storage = new JsonStorageImpl<>();

    @Override
    public void add(University university) {
        if (university != null && !storage.contains(university)) {
            storage.add(university);
        } else {
            System.out.println("University null or already exists");
        }
    }

    @Override
    public OptionalDouble getAverageGrade(int universityId) {
        return storage.getEntityById(universityId)
                .getGroups()
                .stream()
                .map(Group::getStudents)
                .flatMap(students -> students.stream()
                        .map(Student::getGradeList))
                .flatMapToDouble(gradeList -> gradeList.stream()
                        .mapToDouble(Integer::doubleValue))
                .average();
    }

    @Override
    public List<University> getUniversities() {
        return storage.getEntities();
    }
}
