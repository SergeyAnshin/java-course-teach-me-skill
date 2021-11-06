package phones;

public class Phone {
    private String model;

    public Phone(String model) {
        this.model = model;
        System.out.println("конструктор Phone");
    }

    public void call() {
        System.out.println("Звонит phone!");
    }
}
