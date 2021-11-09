package firstpartclass;

public class Cow extends Animal {

    public Cow(String name) {
        super(name);
    }

    @Override
    void voice() {
        System.out.println("Mooo");
    }
}
