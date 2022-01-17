package controllers;

import concole.ConsoleColors;
import entities.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static enums.DefaultTaskCategory.*;

public class BoardMenu extends AbstractMenu {
    private Map<TaskCategory, List<Task>> taskMap;
    private Map<Integer, String> boardMenu = new HashMap<>() {{
        put(0, "Create task");
        put(1, "Edit task");
        put(2, "Delete task");
        put(3, "Create category");
        put(4, "Edit category");
        put(5, "Delete category");
        put(6, "Back to previous page");
        put(7, "Exit");
    }};

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        printMenuTitle("board");
        taskMap = initializeTaskMap(getProject());
        showBordColumn(taskMap);
        return boardMenu;
    }

    private Map<TaskCategory, List<Task>> initializeTaskMap(Project project) {
        return project.getTaskDetailsList()
                .stream()
                .map(TaskDetails::getTask)
                .filter(task -> task.getId() != 0)
                .collect(Collectors.groupingBy(Task::getTaskCategory,
                        () -> new TreeMap<>(Comparator.comparing(TaskCategory::getId)),
                        Collectors.toList()));
    }

    private void showBordColumn(Map<TaskCategory, List<Task>> taskMap) {
        for (Map.Entry<TaskCategory, List<Task>> entry : taskMap.entrySet()) {
            System.out.println(entry.getKey().getName());
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            createTaskInProject(getProject());
        } else if (menuItemToDo == 1) {
            List<Task> potentialTaskToEdit = taskMap.values()
                    .stream()
                    .collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
            if (potentialTaskToEdit != null && !potentialTaskToEdit.isEmpty()) {
                Task taskToEdit = getTaskToChangeFromList(potentialTaskToEdit);
                TaskEditMenu taskEditMenu = new TaskEditMenu(taskToEdit);
                taskEditMenu.startMenu();
                updateBoard();
            } else {
                System.out.println(ConsoleColors.RED + "No task to edit!" + ConsoleColors.RESET);
            }
        } else if (menuItemToDo == 2) {
            deleteTask();
        } else if (menuItemToDo == 3) {
            createTaskCategory();
        } else if (menuItemToDo == 4) {
            editTaskCategory();
        } else if (menuItemToDo == 5) {
            deleteTaskCategory();
        } else if (menuItemToDo == 6) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 7) {
            System.exit(0);
        }
    }

    private void createTaskInProject(Project project) {
        printMenuTitle("create task");
        Task task = CONSOLE_TASK_MANAGER.getEntity();
        TaskDetails taskDetails = new TaskDetails(project, getUser());
        task.setTaskDetails(taskDetails);
        TASK_SERVICE.save(task);
        updateBoard();
    }

    private Task getTaskToChangeFromList(List<Task> potentialTaskToEdit) {
        System.out.println("Choose task to edit:");
        CONSOLE_TASK_MANAGER.printEntityInfo(potentialTaskToEdit);
        return CONSOLE_TASK_MANAGER.selectEntityFromListById(potentialTaskToEdit);
    }

    private void deleteTask() {
        System.out.println("**** DELETE TASK ****");
        List<Task>  potentialTaskToDelete = getProject().getTaskDetailsList()
                .stream()
                .map(TaskDetails::getTask)
                .filter(task -> task.getId() != 0)
                .collect(Collectors.toList());
        if (!potentialTaskToDelete.isEmpty()) {
            System.out.println("Choose one of the tasks:");
            CONSOLE_TASK_MANAGER.printEntityInfo(potentialTaskToDelete);
            Task taskToDelete = CONSOLE_TASK_MANAGER.selectEntityFromListById(potentialTaskToDelete);
            performTaskDeletion(taskToDelete);
            updateBoard();
        } else {
            System.out.println(ConsoleColors.RED + "No tasks to delete!" + ConsoleColors.RESET);
        }
    }

    private void performTaskDeletion(Task taskToDelete) {
        if (getProject().getTaskDetailsList().size() > 1) {
            TASK_SERVICE.delete(taskToDelete);
        } else if (getProject().getTaskDetailsList().size() > 0){
            TaskDetails taskDetails = getProject().getTaskDetailsList().get(0);
            taskDetails.setProject(getProject());
            taskDetails.setTask(null);
            TASK_DETAILS_SERVICE.update(taskDetails);
        }
    }

    private void createTaskCategory() {
        System.out.println("**** CREATE TASK CATEGORY ****");
        TaskCategory taskCategory = CONSOLE_TASK_CATEGORY_MANAGER.getEntity();
        TASK_CATEGORY_SERVICE.save(taskCategory);
    }

    private void editTaskCategory() {
        System.out.println("**** EDIT TASK CATEGORY ****");
        System.out.println("Choose one of the categories:");
        List<TaskCategory> allTaskCategories = TASK_CATEGORY_SERVICE.findAll();
        List<TaskCategory> potentialTaskCategoriesToEdit =
                getTaskCategoriesExcludingDefaultValuesFrom(allTaskCategories);
        if (!potentialTaskCategoriesToEdit.isEmpty()) {
            CONSOLE_TASK_CATEGORY_MANAGER.printEntityInfo(potentialTaskCategoriesToEdit);
            TaskCategory taskCategoryToEdit =
                    CONSOLE_TASK_CATEGORY_MANAGER.selectEntityFromListById(potentialTaskCategoriesToEdit);
            TaskCategory newTaskCategory = CONSOLE_TASK_CATEGORY_MANAGER.getEntity();
            newTaskCategory.setId(taskCategoryToEdit.getId());
            TASK_CATEGORY_SERVICE.update(newTaskCategory);
            updateBoard();
        } else {
            System.out.println(ConsoleColors.RED + "No category to edit!" + ConsoleColors.RESET);
        }
    }

    private List<TaskCategory> getTaskCategoriesExcludingDefaultValuesFrom(List<TaskCategory> taskCategories) {
        return taskCategories.stream()
                .filter(taskCategory -> !taskCategory.equals(TO_DO.getCategory())
                        && !taskCategory.equals(IN_PROGRESS.getCategory())
                        && !taskCategory.equals(DONE.getCategory()))
                .collect(Collectors.toList());
    }

    private void deleteTaskCategory() {
        System.out.println("**** DELETE TASK CATEGORY ****");
        List<TaskCategory> allTaskCategories = TASK_CATEGORY_SERVICE.findAll();
        List<TaskCategory> potentialTaskCategoriesToDelete =
                getTaskCategoriesExcludingDefaultValuesFrom(allTaskCategories);
        if (!potentialTaskCategoriesToDelete.isEmpty()) {
            CONSOLE_TASK_CATEGORY_MANAGER.printEntityInfo(potentialTaskCategoriesToDelete);
            TaskCategory taskCategoryToDelete = CONSOLE_TASK_CATEGORY_MANAGER.selectEntityFromListById(potentialTaskCategoriesToDelete);

            System.out.println("Choose new category for tasks:");
            List<TaskCategory> newTaskCategoriesForTasks = allTaskCategories.stream()
                    .filter(Predicate.not(Predicate.isEqual(taskCategoryToDelete)))
                    .collect(Collectors.toList());
            CONSOLE_TASK_CATEGORY_MANAGER.printEntityInfo(newTaskCategoriesForTasks);
            TaskCategory newTaskCategoryForTasks = CONSOLE_TASK_CATEGORY_MANAGER.selectEntityFromListById(newTaskCategoriesForTasks);

            TASK_SERVICE.changeTaskCategoryForAllTaskWithCurrentCategory(taskCategoryToDelete, newTaskCategoryForTasks);
            TASK_CATEGORY_SERVICE.delete(taskCategoryToDelete);
            updateBoard();
        } else {
            System.out.println(ConsoleColors.RED + "No category to delete!" + ConsoleColors.RESET);
        }

    }

    private void updateBoard() {
        setProject(PROJECT_SERVICE.findById(getProject().getId()));
    }
}