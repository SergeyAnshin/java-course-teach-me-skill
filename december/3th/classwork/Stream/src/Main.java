import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Optional<Integer> optionalInteger = Optional.ofNullable(null);
//        System.out.println(optionalInteger.isPresent());
//        System.out.println(optionalInteger.get());
//        System.out.println(optionalInteger.orElse(5));
//        System.out.println(optionalInteger.orElseGet(() -> 6));
//        System.out.println(optionalInteger.orElseThrow(Exception::new));
//        System.out.println(optionalInteger.get());

//        ArrayList<Integer> list = new ArrayList<>() {{
//            add(5);
//            add(2);
//            add(1);
//            add(7);
//            add(8);
//            add(4);
//            add(0);
//            add(7);
//            add(5);
//        }};
//
//        List<Integer> newList = list.stream()
//                .skip(3)
//                .filter(value -> value % 2 == 0)
//                .collect(Collectors.toList());
//        System.out.println(newList);
//
//        List<Integer> newList2 = list.stream()
//                .skip(3)
//                .limit(3)
//                .filter(value -> value % 2 == 0)
//                .collect(Collectors.toList());
//        System.out.println(newList2);
//
//        List<Integer> newList3 = list.stream()
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(newList3);
//
//        long count = list.stream()
//                .filter(value -> value % 2 == 0)
//                .count();
//        System.out.println(count);
//
//        Optional<Integer> min = list.stream()
//                .filter(value -> value % 2 == 0)
//                .min(Integer::compareTo);
//        min.ifPresent(System.out::println);
//
//        list.stream()
//                .map(p -> p + 5)
//                .forEach(System.out::println);

        ArrayList<Integer> integers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
        }

        System.out.println("Original list - " + integers);

        System.out.println("Number of even numbers - " + integers.stream()
                .filter(number -> number % 2 == 0)
                .count());

        System.out.println("Ascending sort order - " + integers.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList()));

        System.out.println("Descending sort order - " + integers.stream()
                .sorted((numberOne, numberTwo) -> numberTwo - numberOne)
                .collect(Collectors.toList()));

        System.out.println("Min value - " + integers.stream().min(Integer::compareTo).get());

        System.out.println("Max value - " + integers.stream().max(Integer::compareTo).get());

        System.out.println(integers.stream()
                .filter(number -> number > 20)
                .sorted(Integer::compareTo)
                .map(number -> number * 10)
                .collect(Collectors.toList()));

        System.out.println("Max of distinct values - " + integers.stream()
                .skip(5)
                .limit(10)
                .distinct()
                .max(Integer::compareTo).get());

        System.out.println(integers.stream()
                .skip(5)
                .limit(10)
                .sorted((numberOne, numberTwo) -> numberTwo - numberOne)
                .map(number -> number * 10 + 5)
                .collect(Collectors.toList()));
    }
}
