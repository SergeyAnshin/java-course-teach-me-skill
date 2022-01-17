package controllers;

import concole.ConsoleColors;
import concole.impl.ConsoleTaskCategoryManagerImpl;
import entities.*;

import java.util.*;

public class TaskEditMenu extends AbstractMenu {
    private Task taskToEdit;
    private Task newTask;
    private Map<Integer, String> taskEditMenu =  new HashMap<>() {{
        put(0, "Edit name");
        put(1, "Edit task category");
        put(2, "Save changes");
        put(3, "Cancel");
    }};

    public TaskEditMenu(Task taskToEdit) {
        this.taskToEdit = taskToEdit;
        this.newTask = new Task(taskToEdit);
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        printMenuTitle("edit task");
        System.out.println(newTask);
        return taskEditMenu;
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            String newName = CONSOLE_TASK_MANAGER.getStringValueForFieldFromConsole("name");
            newTask.setName(newName);
        } else if (menuItemToDo == 1) {
            TaskCategory newTaskCategory = new ConsoleTaskCategoryManagerImpl().selectTaskCategoryFromDB();
            newTask.setTaskCategory(newTaskCategory);
        } else if (menuItemToDo == 2) {
            if (!taskToEdit.getName().equals(newTask.getName()) ||
                    !taskToEdit.getTaskCategory().equals(newTask.getTaskCategory())) {
                TASK_SERVICE.update(newTask);
            } else {
                System.out.println(ConsoleColors.RED + "You are trying to save an unmodified task!" +
                        ConsoleColors.RESET);
            }
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 3) {
            setWorkingInThisMenu(false);
        }
    }
}
