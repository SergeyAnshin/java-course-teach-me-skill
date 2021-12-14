package services.impl;

import entities.Group;
import entities.Student;
import repositories.Storage;
import repositories.impl.JsonFileStorageImpl;
import services.GroupService;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class GroupServiceImpl implements GroupService<Group> {
    private final Storage<Group> storage =
            new JsonFileStorageImpl<>(new File("groups.txt"), Group.class);

    @Override
    public void add(Group group) {
        if (group != null && !exist(group)) {
            storage.add(group);
        } else {
            System.out.println("Group null or already exists");
        }
    }

    @Override
    public OptionalDouble getAverageGrade(int groupId) {
        Optional<Group> group = getGroupById(groupId);
        if (group.isPresent()) {
            return group.get()
                    .getStudents()
                    .stream()
                    .map(Student::getGradeList)
                    .flatMapToDouble(gradeList -> gradeList.stream()
                            .mapToDouble(Integer::doubleValue))
                    .average();
        } else {
            return OptionalDouble.of(0);
        }

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

    @Override
    public boolean exist(Group group) {
        return getGroups()
                .stream()
                .anyMatch(group1 -> group1.equals(group));
    }
}
