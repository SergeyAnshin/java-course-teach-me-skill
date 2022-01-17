package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * name NOT_NULL
 * key NOT_NULL
 * UNIQUE (key)
 */
public class Project implements Entity {
    private Long id;
    private String name;
    private String key;
    private List<TaskDetails> taskDetailsList;

    public Project() {
    }

    public Project(Long id) {
        this.id = id;
    }

    public Project(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public Project(Long id, String name, String key) {
        this.id = id;
        this.name = name;
        this.key = key;
    }

    public Project(String name, String key, List<TaskDetails> taskDetailsList) {
        this.name = name;
        this.key = key;
        this.taskDetailsList = taskDetailsList;
    }

    public Project(Long id, String name, String key, List<TaskDetails> taskDetailsList) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.taskDetailsList = taskDetailsList;
    }

    public Project(Project project) {
        if (project != null) {
            this.id = project.getId();
            this.name = project.getName();
            this.key = project.getKey();
            if (project.getTaskDetailsList() != null) {
                this.taskDetailsList = new ArrayList<>(project.getTaskDetailsList());
            }
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<TaskDetails> getTaskDetailsList() {
        return taskDetailsList;
    }

    public void setTaskDetailsList(List<TaskDetails> taskDetailsList) {
        this.taskDetailsList = taskDetailsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id.equals(project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", taskDetailsList=" + taskDetailsList +
                '}';
    }
}
