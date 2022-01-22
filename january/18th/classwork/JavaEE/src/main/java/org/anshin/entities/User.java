package org.anshin.entities;

import java.util.List;
import java.util.Objects;

public class User {
    private String login;
    private String password;
    private List<CalculationResult<String>> calculationResultList;
    private boolean authorized;

    public static final String LOGIN_PARAM = "login";
    public static final String PASSWORD_PARAM = "password";
    public static final String SESSION_ATTRIBUTE = "authUser";

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
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

    public List<CalculationResult<String>> getCalculationResultList() {
        return calculationResultList;
    }

    public void setCalculationResultList(List<CalculationResult<String>> calculationResultList) {
        this.calculationResultList = calculationResultList;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
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
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", calculationResultList=" + calculationResultList +
                ", authorized=" + authorized +
                '}';
    }
}
