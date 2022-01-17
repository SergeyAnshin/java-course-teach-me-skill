package entities;

import java.util.List;
import java.util.Objects;

/**
 * login NOT_NULL
 * email NOT_NULL
 * password NOT_NULL
 * UNIQUE (login)
 * UNIQUE (email)
 */
public class User implements Entity {
    private Long id;
    private String login;
    private String email;
    private String password;
    private List<TaskDetails> taskDetailsWhereAuthor;
    private List<TaskDetails> taskDetailsWhereExecutor;
    private boolean isAuthorized;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String login, String email, String password) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String login, String email, String password, List<TaskDetails> taskDetailsWhereAuthor,
                List<TaskDetails> taskDetailsWhereExecutor, boolean isAuthorized) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.taskDetailsWhereAuthor = taskDetailsWhereAuthor;
        this.taskDetailsWhereExecutor = taskDetailsWhereExecutor;
        this.isAuthorized = isAuthorized;
    }

    public User(User user) {
        if (user != null) {
            this.id = user.getId();
            this.login = user.getLogin();
            this.email = user.getEmail();
            this.password = user.getPassword();
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return login;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TaskDetails> getTaskDetailsWhereAuthor() {
        return taskDetailsWhereAuthor;
    }

    public void setTaskDetailsWhereAuthor(List<TaskDetails> taskDetailsWhereAuthor) {
        this.taskDetailsWhereAuthor = taskDetailsWhereAuthor;
    }

    public List<TaskDetails> getTaskDetailsWhereExecutor() {
        return taskDetailsWhereExecutor;
    }

    public void setTaskDetailsWhereExecutor(List<TaskDetails> taskDetailsWhereExecutor) {
        this.taskDetailsWhereExecutor = taskDetailsWhereExecutor;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
