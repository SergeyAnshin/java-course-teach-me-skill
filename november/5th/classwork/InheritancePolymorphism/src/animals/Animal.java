package animals;

public abstract class Animal {
    private String brain;
    private String heart;
    private String genitals;

    public Animal(String brain, String heart, String genitals) {
        this.brain = brain;
        this.heart = heart;
        this.genitals = genitals;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "brain='" + brain + '\'' +
                ", heart='" + heart + '\'' +
                ", genitals='" + genitals + '\'' +
                '}';
    }
}
