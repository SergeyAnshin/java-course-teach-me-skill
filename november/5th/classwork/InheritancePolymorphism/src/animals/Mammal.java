package animals;

public abstract class Mammal extends Animal implements Actions {
    private int milkVolume;

    public Mammal(String brain, String heart, String genitals, int milkVolume) {
        super(brain, heart, genitals);
        this.milkVolume = milkVolume;
    }

    @Override
    public String toString() {
        return "Mammal{" + super.toString() +
                "milkVolume=" + milkVolume +
                '}';
    }
}

