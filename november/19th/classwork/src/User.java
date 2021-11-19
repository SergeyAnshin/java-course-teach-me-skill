import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private double requiredMaxPrice;
    private double requiredMaxSpeed;
    private Set<String> requiredMark = Set.of("BMW", "VOLVO", "RENAULT");

    public User() {
    }

    public User(String name, double requiredMaxPrice, double requiredMaxSpeed, Set<String> requiredMark) {
        this.name = name;
        this.requiredMaxPrice = requiredMaxPrice;
        this.requiredMaxSpeed = requiredMaxSpeed;
        this.requiredMark = requiredMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRequiredMaxPrice() {
        return requiredMaxPrice;
    }

    public void setRequiredMaxPrice(double requiredMaxPrice) {
        this.requiredMaxPrice = requiredMaxPrice;
    }

    public double getRequiredMaxSpeed() {
        return requiredMaxSpeed;
    }

    public void setRequiredMaxSpeed(double requiredMaxSpeed) {
        this.requiredMaxSpeed = requiredMaxSpeed;
    }

    public Set<String> getRequiredMark() {
        return requiredMark;
    }

    public void setRequiredMark(Set<String> requiredMark) {
        this.requiredMark = requiredMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.requiredMaxPrice, requiredMaxPrice) == 0 && Double.compare(user.requiredMaxSpeed, requiredMaxSpeed) == 0 && Objects.equals(name, user.name) && Objects.equals(requiredMark, user.requiredMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, requiredMaxPrice, requiredMaxSpeed, requiredMark);
    }
}
