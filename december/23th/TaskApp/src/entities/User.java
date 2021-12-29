package entities;

import java.util.List;

public class User {
    private Long id;
    private String login;
    private String password;
    private String email;
    private List<Task> tasksWhereAuthor;
    private List<Task> tasksWhereExecutor;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(Long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasksWhereAuthor() {
        return tasksWhereAuthor;
    }

    public void setTasksWhereAuthor(List<Task> tasksWhereAuthor) {
        this.tasksWhereAuthor = tasksWhereAuthor;
    }

    public List<Task> getTasksWhereExecutor() {
        return tasksWhereExecutor;
    }

    public void setTasksWhereExecutor(List<Task> tasksWhereExecutor) {
        this.tasksWhereExecutor = tasksWhereExecutor;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", tasksWhereAuthor=" + tasksWhereAuthor +
                ", tasksWhereExecutor=" + tasksWhereExecutor +
                '}';
    }
}
