package groups;

import java.util.Date;

public class Person {
    private Date birthday;
    private String firstName;
    private String lastname;

    public Person() {
    }

    public Person(Date birthday, String firstName, String lastname) {
        this.birthday = birthday;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "groups.Person{" +
                "birthday=" + birthday +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
