package entities;

import java.util.Objects;

/**
 * name NOT_NULL
 * taskCategory NOT_NULL FOREIGN_KEY
 */
public class Task implements Entity {
    private Long id;
    private String name;
    private TaskCategory taskCategory;
    private TaskDetails taskDetails;

    public Task(String name) {
        this.name = name;
    }

    public Task(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Task(String name, TaskCategory taskCategory) {
        this.name = name;
        this.taskCategory = taskCategory;
    }

    public Task(Task task) {
        if (task != null) {
            this.id = task.getId();
            this.name = task.getName();
            this.taskCategory = new TaskCategory(task.getTaskCategory());
            this.taskDetails = new TaskDetails(task.getTaskDetails());
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

    public TaskDetails getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(TaskDetails taskDetails) {
        this.taskDetails = taskDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskCategory=" + taskCategory +
                ", taskDetails=" + taskDetails +
                '}';
    }
}
