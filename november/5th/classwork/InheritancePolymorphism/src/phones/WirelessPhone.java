package phones;

public class WirelessPhone extends Phone {
    private String formFactor;

    public WirelessPhone(String model, String formFactor) {
        super(model);
        this.formFactor = formFactor;
        System.out.println("Конструктор wirelessPhone");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("Звонит wirelessPhone!");
    }
}
