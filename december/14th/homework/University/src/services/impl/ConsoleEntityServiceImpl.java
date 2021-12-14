package services.impl;

import entities.Group;
import entities.HardCodeEntities;
import entities.Student;
import entities.University;
import services.ConsoleEntityService;
import services.ConsoleOperationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ConsoleEntityServiceImpl implements ConsoleEntityService {
    private final ConsoleOperationService operationService = new ConsoleOperationServiceImpl();
    private HardCodeEntities hardCodeEntities = new HardCodeEntities();
    private int studentCounter = 0;
    private int groupCounter = 0;
    private int universityCounter = 0;

    @Override
    public <T> T createEntityBy(int classNumber) {
        if (classNumber == 0) {
            return (T) getStudentFromConsole();
        } else if (classNumber == 1) {
            return (T) getGroupFromConsole();
        } else if (classNumber == 2) {
            return (T) getUniversityFromConsole();
        } else {
            return null;
        }
    }

    private Object getUniversityFromConsole() {
        List<University> universities = hardCodeEntities.getUniversities();

        if (universityCounter >= universities.size()) {
            universityCounter = 0;
        }

        return universities.get(universityCounter++);
    }

    private Object getGroupFromConsole() {
        List<Group> groups = hardCodeEntities.getGroups();

        if (groupCounter >= groups.size()) {
            groupCounter = 0;
        }

        return groups.get(groupCounter++);
    }

    private Object getStudentFromConsole() {
        List<Student> students = hardCodeEntities.getStudents();

        if (studentCounter >= students.size()) {
            studentCounter = 0;
        }

        return students.get(studentCounter++);
    }
}
