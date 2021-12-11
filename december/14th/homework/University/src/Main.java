import entities.Group;
import entities.Student;
import repositories.impl.JsonStorageImpl;
import repositories.Storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>() {{
            add(new Student(1, "Tom", "Ford", List.of(1, 3, 4)));
            add(new Student(2, "Bob", "Green", List.of(5, 5, 4)));
            add(new Student(3, "Frodo", "Gun", List.of(2, 1, 3)));
        }};

//        Storage<Student> studentStorage = new JsonStorageImpl<>();
//        for (Student student : students) {
//            studentStorage.add(student);
//        }
//
//        System.out.println(studentStorage.getEntities());


        List<Group> groups = new ArrayList<>() {{
            add(new Group(1, "g1", new HashSet<>(students)));
            add(new Group(2, "g2", new HashSet<>(students)));
        }};

        Storage<Group> groupStorage = new JsonStorageImpl<>();
        for (Group group : groups) {
            groupStorage.add(group);
        }

        System.out.println(groupStorage.getEntities().get(0).getId());


    }
}
