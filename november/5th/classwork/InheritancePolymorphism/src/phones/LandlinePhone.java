package phones;

public class LandlinePhone extends Phone {
    private String numberButton;

    public LandlinePhone(String model, String numberButton) {
        super(model);
        this.numberButton = numberButton;
        System.out.println("Конструктор landlinePhone");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("Звонит landlinePhone!");
    }
}
