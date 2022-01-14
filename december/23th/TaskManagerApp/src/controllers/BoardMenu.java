package controllers;

import concole.ConsoleEntityManager;
import concole.impl.ConsoleTaskCategoryManagerImpl;
import concole.impl.ConsoleTaskManagerImpl;
import entities.*;
import services.ProjectService;
import services.TaskCategoryService;
import services.TaskDetailsService;
import services.TaskService;
import services.impl.ProjectServiceImpl;
import services.impl.TaskCategoryServiceImpl;
import services.impl.TaskDetailsServiceImpl;
import services.impl.TaskServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * обнуление task_id в task_details
 */

public class BoardMenu extends AbstractMenu {
    private Project project;
    private Map<TaskCategory, List<Task>> taskMap;
    private ConsoleEntityManager<Task> taskManager = new ConsoleTaskManagerImpl();
    private ConsoleEntityManager<TaskCategory> taskCategoryManager = new ConsoleTaskCategoryManagerImpl();
    private TaskCategoryService<TaskCategory> taskCategoryService = new TaskCategoryServiceImpl();
    private TaskDetailsService<TaskDetails> taskDetailsService = new TaskDetailsServiceImpl();
    private ProjectService<Project> projectService = new ProjectServiceImpl();
    private TaskService<Task> taskService = new TaskServiceImpl();
    private Map<Integer, String> boardMenu = new HashMap<>() {{
        put(0, "Create task");
        put(1, "Edit task"); // доделать
        put(2, "Delete task"); // доделать
        put(3, "Create category");
        put(4, "Edit category"); // доделать
        put(5, "Delete category"); // доделать
        put(6, "Project menu");
        put(7, "Exit");
    }};

    public BoardMenu(Project project) {
        this.project = project;
    }

    @Override
    protected Map<Integer, String> getMenuForUser(User user) {
        System.out.println("**** BOARD ****");
        initializeTaskMap();
        showBordColumn();
        return boardMenu;
    }

    private void initializeTaskMap() {
        taskMap = project.getTaskDetailsList()
                .stream()
                .map(TaskDetails::getTask)
                .filter(task -> task.getId() != 0)
                .collect(Collectors.groupingBy(Task::getTaskCategory,
                        () -> new TreeMap<>(Comparator.comparing(TaskCategory::getId)),
                        Collectors.toList()));
    }

    private void showBordColumn() {
        for (Map.Entry<TaskCategory, List<Task>> entry : taskMap.entrySet()) {
            System.out.println(entry.getKey().getName());
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }

    @Override
    protected void doMenuItemInMenu(long menuItemToDo, Map<Integer, String> menu) {
        if (menuItemToDo == 0) {
            System.out.println("**** CREATE TASK ****");
            Task task = getTaskEntityFromConsole();
            TaskDetails taskDetails = new TaskDetails(project, getUser());
            task.setTaskDetails(taskDetails);
            taskService.save(task);
            project = projectService.findById(project.getId());
        } else if (menuItemToDo == 1) {

        } else if (menuItemToDo == 2) {
            System.out.println("**** DELETE TASK ****");
            List<Task> tasks = project.getTaskDetailsList().stream().map(TaskDetails::getTask).collect(Collectors.toList());
            Task taskToDelete = taskManager.selectEntityFromListById(tasks);
            deleteTask(taskToDelete);
            project = projectService.findById(project.getId());
        } else if (menuItemToDo == 3) {
            System.out.println("**** CREATE TASK CATEGORY ****");
            TaskCategory taskCategory = taskCategoryManager.getEntity();
            taskCategoryService.save(taskCategory);
        } else if (menuItemToDo == 4) {

        } else if (menuItemToDo == 5) {

        } else if (menuItemToDo == 6) {
            setWorkingInThisMenu(false);
        } else if (menuItemToDo == 7) {
            System.exit(0);
        }
    }

    private void deleteTask(Task taskToDelete) {
        if (project.getTaskDetailsList().size() > 1) {
            taskService.delete(taskToDelete);
        } else if (project.getTaskDetailsList().size() > 0){
            TaskDetails taskDetails = project.getTaskDetailsList().get(0);
            taskDetails.setTask(null);
            taskDetailsService.update(taskDetails);
        }
    }

    private Task getTaskEntityFromConsole() {
        Task task = taskManager.getEntity();
        TaskCategory taskCategory = getCategory();
        task.setTaskCategory(taskCategory);
        return task;
    }

    private TaskCategory getCategory() {
        System.out.println("Choose one of the categories:");
        List<TaskCategory> taskCategories = taskCategoryService.findAll();
        showPossibleTaskCategories(taskCategories);
        return taskCategoryManager.selectEntityFromListById(taskCategories);
    }

    private void showPossibleTaskCategories(List<TaskCategory> taskCategories) {
        for (TaskCategory taskCategory : taskCategories) {
            System.out.println("id - " + taskCategory.getId() + ", name - " + taskCategory.getName());
        }
    }
}
