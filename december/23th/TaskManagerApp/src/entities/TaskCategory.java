package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * name NOT_NULL
 * UNIQUE (name)
 */
public class TaskCategory implements Entity {
    private Long id;
    private String name;
    private List<Task> tasks;

    public TaskCategory(String name) {
        this.name = name;
    }

    public TaskCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TaskCategory(TaskCategory taskCategory) {
        if (taskCategory != null) {
            this.id = taskCategory.getId();
            this.name = taskCategory.getName();
            this.tasks = taskCategory.getTasks() != null ? new ArrayList<>(taskCategory.getTasks()) : null;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskCategory that = (TaskCategory) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "TaskCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
