package entities;

import java.util.Objects;
import java.util.Set;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Set<Card> cards;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, Set<Card> cards) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(cards, person.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cards);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cards=" + cards +
                '}';
    }
}
