package controllers;

import entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BoardMenu extends AbstractMenu {
    private Project project;
    private Map<Integer, String> boardMenu = new HashMap<>() {{
        put(0, "Find task");
        put(1, "Edit email");
        put(2, "Edit password");
        put(3, "Main menu");
        put(4, "Exit");
    }};

    public BoardMenu(Project project) {
        this.project = project;
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        System.out.println("**** BOARD ****");
        showBordColumn();
        return boardMenu;
    }

    private void showBordColumn() {
//        List<TaskCategory> taskCategories = project.getTaskDetailsList()
//                .stream()
//                .map(TaskDetails::getTask)
//                .map(Task::getTaskCategory)
//                .collect(Collectors.toList());
        Map<TaskCategory, Task> taskCategoryListTaskMap = project.getTaskDetailsList()
                .stream()
                .map(TaskDetails::getTask)
                .collect(Collectors.toMap(Task::getTaskCategory, Function.identity()));
        System.out.println(taskCategoryListTaskMap);
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 4) {
            System.exit(0);
        }
    }
}
