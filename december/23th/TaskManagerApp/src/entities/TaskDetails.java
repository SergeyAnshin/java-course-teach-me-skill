package entities;

/**
 * project NOT_NULL FOREIGN_KEY
 * task NOT_NULL FOREIGN_KEY
 * author NOT_NULL FOREIGN_KEY
 * executor FOREIGN_KEY
 * UNIQUE (project, task)
 */
public class TaskDetails implements Entity {
    private Long id;

    private Project project;
    private Task task;
    private User author;
    private User executor;

    public TaskDetails(Project project, User author) {
        this.project = project;
        this.author = author;
    }

    public TaskDetails(Long id, Project project, Task task, User author, User executor) {
        this.id = id;
        this.project = project;
        this.task = task;
        this.author = author;
        this.executor = executor;
    }

    public TaskDetails(Long id, Task task, User author, User executor) {
        this.id = id;
        this.task = task;
        this.author = author;
        this.executor = executor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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
        return "TaskDetails{" +
                "id=" + id +
                ", project=" + project +
                ", task=" + task +
                ", author=" + author +
                ", executor=" + executor +
                '}';
    }
}
