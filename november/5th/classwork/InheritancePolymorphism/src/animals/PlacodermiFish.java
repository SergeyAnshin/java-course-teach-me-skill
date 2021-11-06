package animals;

public class PlacodermiFish extends Fish {
    private int shellStrength;

    public PlacodermiFish(String brain, String heart, String genitals, int deepWaterEnvironment, int shellStrength) {
        super(brain, heart, genitals, deepWaterEnvironment);
        this.shellStrength = shellStrength;
    }


    @Override
    public void move() {
        System.out.println("Placodermi fish swim!!!");
    }

    @Override
    public void eat() {
        System.out.println("Placodermi fish eat!!!");
    }

    @Override
    public String toString() {
        return "PlacodermiFish{" + super.toString() +
                "shellStrength=" + shellStrength +
                '}';
    }
}
