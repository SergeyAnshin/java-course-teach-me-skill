package services.impl;

import entities.Group;
import entities.Menu;
import entities.Student;
import entities.University;
import repositories.Storage;
import repositories.impl.JsonFileStorageImpl;
import services.*;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class MenuServiceImp implements MenuService {
    private final List<String> mainMenuItem = List.of("Add entity", "Get average grade", "Show entity", "Exit");
    private final List<String> entityMenu = List.of("Student", "Group", "University");
    private final ConsoleOperationService operationService = new ConsoleOperationServiceImpl();
    private final ConsoleEntityService entityService = new ConsoleEntityServiceImpl();
    private final StudentService<Student> studentService = new StudentServiceImpl();
    private final GroupService<Group> groupService = new GroupServiceImpl();
    private final UniversityService<University> universityService = new UniversityServiceImpl();

    @Override
    public void start() {
        Menu mainMenu = create(mainMenuItem);
        while (true) {
            show(mainMenu);
            int menuItemToDo = operationService.getNumberFromTo(0, mainMenuItem.size() - 1);
            doMenuItemInMenu(menuItemToDo, mainMenu);
        }
    }

    @Override
    public Menu create(List<String> menuItems) {
        Map<Integer, String> menu = menuItems.stream()
                .collect(Collectors.toMap(menuItems::indexOf, value -> value));
        return new Menu(menu);

    }

    @Override
    public void show(Menu menu) {
        menu.getMenu().forEach((key, value) -> System.out.println(key + " - " + value));
    }

    @Override
    public void doMenuItemInMenu(int menuItem, Menu menu) {
        if (menuItem == 3) {
            System.exit(0);
        }

        Menu entityMenu = create(this.entityMenu);
        show(entityMenu);
        int menuItemToDo = operationService.getNumberFromTo(0, entityMenu.getMenu().size() - 1);
        if (menuItem == 0) {
            addEntityInStorage(entityService.createEntityBy(menuItemToDo));
        } else if (menuItem == 1) {
            showAverageGrade(menuItemToDo);
        } else if (menuItem == 2) {
            showInformationAbout(menuItemToDo);
        }
    }

    private void showAverageGrade(int menuItemToDo) {
        System.out.println("Enter entity id: ");
        int entityId = operationService.getNumberFromTo(0, Integer.MAX_VALUE);
        if (menuItemToDo == 0) {
            System.out.println(studentService.getAverageGrade(entityId));
        } else if (menuItemToDo == 1) {
            System.out.println(groupService.getAverageGrade(entityId));
        } else if (menuItemToDo == 2) {
            System.out.println(universityService.getAverageGrade(entityId));
        }
    }

    private void addEntityInStorage(Object entity) {
        if (entity.getClass() == Student.class) {
            studentService.add((Student) entity);
        } else if (entity.getClass() == Group.class) {
            groupService.add((Group) entity);
        } else {
            universityService.add((University) entity);
        }
    }

    private void showInformationAbout(int menuItemToDo) {
        if (menuItemToDo == 0) {
            System.out.println(studentService.getStudents());
        } else if (menuItemToDo == 1) {
            System.out.println(groupService.getGroups());
        } else {
            System.out.println(universityService.getUniversities());
        }
    }
}
