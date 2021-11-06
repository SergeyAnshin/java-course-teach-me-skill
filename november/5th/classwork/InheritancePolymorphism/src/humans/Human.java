package humans;

public class Human {
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void printInformation() {
        System.out.println("Мне " + age + " лет");
        System.out.println("Меня зовут: " + name);
    }

}
