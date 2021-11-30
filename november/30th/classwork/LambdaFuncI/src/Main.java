import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MyInterface myInterface = Integer::sum;
//        System.out.println(myInterface.action(3,2));

        Operation<Integer> add = (a, b) -> a + b;
        Operation<Integer> subtract = (a, b) -> a - b;
        Operation<Integer> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> a / b;

        System.out.println(add.calculate(1,2));
        System.out.println(subtract.calculate(1,2));
        System.out.println(multiply.calculate(1,2));
        System.out.println(divide.calculate(1d,2d));

        List<Integer> list = List.of(1, 3, 4);
        Action action = () -> System.out.println(list);
        action.print();

        OperationTwo<List> operation = System.out::println;
        operation.action(list);
    }
}
