package entities;

import java.util.Objects;
import java.util.Set;

public class University {
    private int id;
    private String name;
    private Set<Group> groups;

    public University() {
    }

    public University(int id, String name, Set<Group> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "entities.University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
