package humans;

public class Employee extends Human {
    private String workingPlace;

    public Employee(int age, String name, String workingPlace) {
        super(age, name);
        this.workingPlace = workingPlace;
    }

    @Override
    public void printInformation() {
        super.printInformation();
        System.out.println("Я работаю на " + workingPlace);
    }
}
