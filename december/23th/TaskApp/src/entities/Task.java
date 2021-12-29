package entities;

public class Task {
    private Long id;
    private String name;
    private TaskCategory taskCategory;
    private User author;
    private User executor;

    public Task(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Task(Long id, String name, TaskCategory taskCategory) {
        this.id = id;
        this.name = name;
        this.taskCategory = taskCategory;
    }

    public Task(String name, TaskCategory taskCategory) {
        this.name = name;
        this.taskCategory = taskCategory;
    }

    public Task(String name, TaskCategory taskCategory, User author) {
        this.name = name;
        this.taskCategory = taskCategory;
        this.author = author;
    }

    public Task(Long id, String name, TaskCategory taskCategory, User author) {
        this.id = id;
        this.name = name;
        this.taskCategory = taskCategory;
        this.author = author;
    }

    public Task(Long id, String name, TaskCategory taskCategory, User author, User executor) {
        this.id = id;
        this.name = name;
        this.taskCategory = taskCategory;
        this.author = author;
        this.executor = executor;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskCategory=" + taskCategory +
                ", author=" + author +
                ", executor=" + executor +
                '}';
    }
}
