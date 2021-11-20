import java.util.Objects;

public class User {
    private String name;
    private Card card;

    public User() {
    }

    public User(String name, Card card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && card.equals(user.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, card);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", card=" + card +
                '}';
    }
}
