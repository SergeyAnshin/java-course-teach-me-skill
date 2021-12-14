package entities;

import java.util.*;

public class HardCodeEntities {
    public List<Student> students = new ArrayList<>() {{
        add(new Student(1, "A", "S1", List.of(1, 2)));
        add(new Student(2, "B", "S2", List.of(4, 2)));
        add(new Student(3, "C", "S3", List.of(2, 2)));
        add(new Student(4, "D", "S4", List.of(7, 8)));
        add(new Student(5, "F", "S5", List.of(9, 10)));
        add(new Student(6, "G", "S6", List.of(1, 2)));
    }};

    public List<Student> getStudents() {
        return students;
    }

    public List<Group> getGroups() {
        List<Student> studentsList = new ArrayList<>(){{
            add(students.get(0));
            add(students.get(1));
            add(students.get(2));
        }};

        List<Student> studentsList1 = new ArrayList<>(){{
            add(students.get(3));
            add(students.get(4));
            add(students.get(5));
        }};

        List<Group> groups = new ArrayList<>() {{
            add(new Group(1, "g1", new HashSet<>(studentsList)));
            add(new Group(2, "g2", new HashSet<>(studentsList1)));
        }};

        return groups;
    }

    public List<University> getUniversities() {
        List<University> universities = new ArrayList<>() {{
            add(new University(1, "u1", new HashSet<>(getGroups())));
        }};
        return universities;
    }
}
