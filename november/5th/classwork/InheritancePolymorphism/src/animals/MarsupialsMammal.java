package animals;

public class MarsupialsMammal extends Mammal {
    private int bagVolume;

    public MarsupialsMammal(String brain, String heart, String genitals, int milkVolume, int bagVolume) {
        super(brain, heart, genitals, milkVolume);
        this.bagVolume = bagVolume;
    }

    @Override
    public void move() {
        System.out.println("Marsupials mammal move!!!");
    }

    @Override
    public void eat() {
        System.out.println("Marsupials mammal eat!!!");
    }

    @Override
    public String toString() {
        return "MarsupialsMammal{" + super.toString() +
                "bagVolume=" + bagVolume +
                '}';
    }
}
