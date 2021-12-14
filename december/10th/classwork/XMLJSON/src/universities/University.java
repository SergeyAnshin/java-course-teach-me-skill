package universities;

import java.util.List;

public class University {
    private String name;
    private List<Group> groups;

    public University() {
    }

    public University(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
