package org.sergey.ans.entity.jpa;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "User.findAllByName", query = "select u from User u where u.name = :name")
})
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phoneList;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
