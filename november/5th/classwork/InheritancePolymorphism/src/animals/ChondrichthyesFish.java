package animals;

public class ChondrichthyesFish extends Fish {
    private int numberCartilage;

    public ChondrichthyesFish(String brain, String heart, String genitals, int deepWaterEnvironment, int numberCartilage) {
        super(brain, heart, genitals, deepWaterEnvironment);
        this.numberCartilage = numberCartilage;
    }

    @Override
    public void move() {
        System.out.println("Chondrichthyes fish swim!!!");
    }

    @Override
    public void eat() {
        System.out.println("Chondrichthyes fish eat!!!");
    }

    @Override
    public String toString() {
        return "ChondrichthyesFish{" + super.toString() +
                "numberCartilage=" + numberCartilage +
                '}';
    }
}
