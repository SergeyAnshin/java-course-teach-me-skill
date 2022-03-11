package org.anshin.entity;

import org.anshin.enums.Role;

import java.util.List;
import java.util.Objects;

public class User extends Entity {
    private String email;
    private String login;
    private String password;
    private List<CalculationResult> calculationResultList;
    private boolean authorized;
    private Role role;
    private String keyword;

    public User() {
    }

    public User(String email, String login) {
        this.email = email;
        this.login = login;
    }

    public User(long id, String email, String login) {
        super(id);
        this.email = email;
        this.login = login;
    }

    public User(String email, String login, String password, Role role) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<CalculationResult> getCalculationResultList() {
        return calculationResultList;
    }

    public void setCalculationResultList(List<CalculationResult> calculationResultList) {
        this.calculationResultList = calculationResultList;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", calculationResultList=" + calculationResultList +
                ", authorized=" + authorized +
                ", role=" + role +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
