package entities;

import java.util.List;

/**
 * name NOT_NULL
 * UNIQUE (name)
 */
public class TaskCategory implements Entity {
    private Long id;
    private String name;

    private List<Task> tasks;

    public TaskCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
