package animals;

public abstract class Fish extends Animal implements Actions {
    private int deepWaterEnvironment;

    public Fish(String brain, String heart, String genitals, int deepWaterEnvironment) {
        super(brain, heart, genitals);
        this.deepWaterEnvironment = deepWaterEnvironment;
    }

    @Override
    public String toString() {
        return "Fish{" + super.toString()  +
                "deepWaterEnvironment=" + deepWaterEnvironment +
                '}';
    }
}
