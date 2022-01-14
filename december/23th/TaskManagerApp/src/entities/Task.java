package entities;

/**
 * name NOT_NULL
 * taskCategory NOT_NULL FOREIGN_KEY
 */
public class Task implements Entity {
    private Long id;
    private String name;
    private TaskCategory taskCategory;
    private TaskDetails taskDetails;

    public Task(Long id) {
        this.id = id;
    }

    public Task(String name) {
        this.name = name;
    }

    public Task(Long id, String name) {
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
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskCategory=" + taskCategory +
                ", taskDetails=" + taskDetails +
                '}';
    }
}
