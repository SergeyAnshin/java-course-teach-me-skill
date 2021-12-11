package services.impl;

import entities.Group;
import entities.Student;
import repositories.Storage;
import repositories.impl.JsonStorageImpl;
import services.GroupService;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class GroupServiceImpl implements GroupService<Group> {
    private final Storage<Group> storage = new JsonStorageImpl<>();

    @Override
    public void add(Group group) {
        if (group != null && !storage.contains(group)) {
            storage.add(group);
        } else {
            System.out.println("Group null or already exists");
        }
    }

    @Override
    public OptionalDouble getAverageGrade(int groupId) {
        return storage.getEntityById(groupId)
                .getStudents()
                .stream()
                .map(Student::getGradeList)
                .flatMapToDouble(gradeList -> gradeList.stream()
                        .mapToDouble(Integer::doubleValue))
                .average();
    }

    @Override
    public List<Group> getGroups() {
        return storage.getEntities();
    }

    @Override
    public Optional<Group> getGroupById(int groupId) {
        return storage.getEntities()
                .stream()
                .filter(group -> group.getId() == groupId)
                .findFirst();
    }
}
