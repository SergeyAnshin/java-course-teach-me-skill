package universities;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Integer> listGrade;

    public Student() {
    }

    public Student(String firstName, String lastName, List<Integer> listGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.listGrade = listGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Integer> getListGrade() {
        return listGrade;
    }

    public void setListGrade(List<Integer> listGrade) {
        this.listGrade = listGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", listGrade=" + listGrade +
                '}';
    }

}
