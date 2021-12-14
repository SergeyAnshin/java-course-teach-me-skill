package groups;

import universities.Student;

import java.util.List;

public class Group {
    private String name;
    private List<Person> member;

    public Group() {
    }

    public Group(String name, List<Person> member) {
        this.name = name;
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getMember() {
        return member;
    }

    public void setMember(List<Person> member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "groups.Group{" +
                "name='" + name + '\'' +
                ", member=" + member +
                '}';
    }
}
