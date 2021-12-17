package services.impl;

import entities.Group;
import entities.Student;
import entities.University;
import repositories.Storage;
import repositories.impl.JsonFileStorageImpl;
import services.UniversityService;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class UniversityServiceImpl implements UniversityService<University> {
    private final Storage<University> storage =
            new JsonFileStorageImpl<>(new File("universities.json"),University.class);

    @Override
    public void add(University university) {
        if (university != null && !exist(university)) {
            storage.add(university);
        } else {
            System.out.println("University null or already exists");
        }
    }

    @Override
    public OptionalDouble getAverageGrade(int universityId) {
        Optional<University> university = getUniversityById(universityId);
        if (university.isPresent()) {
            return university.get()
                    .getGroups()
                    .stream()
                    .map(Group::getStudents)
                    .flatMap(students -> students.stream()
                            .map(Student::getGradeList))
                    .flatMapToDouble(gradeList -> gradeList.stream()
                            .mapToDouble(Integer::doubleValue))
                    .average();
        } else {
            return OptionalDouble.of(0);
        }
    }

    @Override
    public List<University> getUniversities() {
        return storage.getEntities();
    }

    @Override
    public boolean exist(University university) {
        return storage.exist(university);
    }

    @Override
    public Optional<University> getUniversityById(int universityId) {
        return getUniversities()
                .stream()
                .filter(university -> university.getId() == universityId)
                .findFirst();
    }
}
