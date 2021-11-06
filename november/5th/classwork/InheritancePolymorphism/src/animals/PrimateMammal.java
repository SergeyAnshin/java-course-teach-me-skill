package animals;

public class PrimateMammal extends Mammal {
    private int iqLevel;

    public PrimateMammal(String brain, String heart, String genitals, int milkVolume, int iqLevel) {
        super(brain, heart, genitals, milkVolume);
        this.iqLevel = iqLevel;
    }


    @Override
    public void move() {
        System.out.println("Primate mammal move!!!");
    }

    @Override
    public void eat() {
        System.out.println("Primate mammal eat!!!");
    }

    @Override
    public String toString() {
        return "PrimateMammal{" + super.toString() +
                "iqLevel=" + iqLevel +
                '}';
    }
}
