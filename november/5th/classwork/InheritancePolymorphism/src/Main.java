import animals.*;
import math.Add;
import math.Divide;
import math.Multiply;
import math.Subtract;
import phones.LandlinePhone;
import phones.Phone;
import phones.WirelessPhone;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        humans.Employee employee = new humans.Employee(25, "Вася", "Интеграл");
//        employee.printInformation();

//        Phone phone = new Phone("abcd");
//        phone.call();
//        LandlinePhone landlinePhone = new LandlinePhone("afg", "123");
//        landlinePhone.call();
//        WirelessPhone wirelessPhone = new WirelessPhone("sfmdkldsm", "kmdsfl");
//        wirelessPhone.call();

//        flights.Dandelion dandelion = new flights.Dandelion();
//        flights.Plane plane = new flights.Plane();
//        dandelion.fly();
//        plane.fly();

//        double firstNumber = 12.0d;
//        double secondNumber = 2.0d;
//        Add add = new Add();
//        double result1 = add.action(firstNumber, secondNumber);
//        System.out.println(result1);
//        Divide divide = new Divide();
//        double result2 = divide.action(firstNumber, secondNumber);
//        System.out.println(result2);
//        Multiply multiply = new Multiply();
//        double result3 = multiply.action(firstNumber, secondNumber);
//        System.out.println(result3);
//        Subtract subtract = new Subtract();
//        double result4 = subtract.action(firstNumber, secondNumber);
//        System.out.println(result4);

        List<Actions> animals = new ArrayList<>() {{
            add(new MarsupialsMammal("marsupialsBrain", "marsupialsHeart", "marsupialsGenitals", 5, 6));
            add(new PrimateMammal("primateBrain", "primateHeart", "primateGenitals", 7, 8));
            add(new PlacodermiFish("placodermiBrain", "placodermiHeart", "placodermiGenitals", 9, 10));
            add(new ChondrichthyesFish("chondrichthyesBrain", "chondrichthyesHeart", "chondrichthyesGenitals", 11, 12));
        }};

        for (Actions animal : animals) {
            animal.move();
            animal.eat();
            System.out.println(animal);
            System.out.println();
        }
    }
}
