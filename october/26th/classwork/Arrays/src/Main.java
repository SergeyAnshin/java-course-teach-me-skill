import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        int[] array = new int[4];
//        Random number = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = number.nextInt(100);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

        int arrayLength = 30;
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));

        // Посчитать количество четных элементов массива
        int numberEvenNumbers = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] % 2 == 0) {
                numberEvenNumbers++;
            }
        }
        System.out.println(numberEvenNumbers);
        System.out.println(Arrays.stream(array).filter(value -> value % 2 == 0).count());

        // Посчитать сумму нечетных элементов
        int sumOddNumbers = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] % 2 != 0) {
                sumOddNumbers += array[i];
            }
        }
        System.out.println(sumOddNumbers);
        System.out.println(Arrays.stream(array).filter(value -> value % 2 != 0).sum());

        // Найти среднее арифметическое элементов массива больше 20
        int sum = 0;
        int numberElement = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] > 20) {
                sum += array[i];
                numberElement++;
            }
        }
        double average = (double) sum / numberElement;
        System.out.println(average);
        System.out.println(Arrays.stream(array).filter(value -> value > 20).average());

        // «Сожмите» массив, выбросив из него каждый второй элемент. «Освободившиеся» места массива заполните нулями.
        int[] array1 = Arrays.copyOf(array, arrayLength);
        for (int i = 0; i < arrayLength - 1; i++) {
            array1[i++] = 0;
        }
        System.out.println(Arrays.toString(array1));



        // Проверить различны ли массивы
        int[] array2 = Arrays.copyOf(array, arrayLength);
        int[] array3 = Arrays.copyOf(array, arrayLength);
        array3[5] *= 2;
        boolean flag = false;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] != array2[i]) {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        boolean flag2 = false;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] != array3[i]) {
                flag2 = false;
                break;
            } else {
                flag = true;
            }
        }

        if (flag == false) {
            System.out.println("Arrays not equals");
        } else {
            System.out.println("Arrays equals");
        }

        if (flag2 == false) {
            System.out.println("Arrays not equals");
        } else {
            System.out.println("Arrays equals");
        }

        System.out.println(Arrays.compare(array, array2));
        System.out.println(Arrays.compare(array, array3));

        // Найти наименьший элемент среди элементов с четными индексами массива
        int minElement = array[0];
        for (int i = 2; i < arrayLength; i += 2) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        System.out.println(minElement);
        Arrays.sort(array);
        System.out.println(Arrays.stream(array).filter(value -> Arrays.binarySearch(array, value) % 2 == 0).min());

        // Найти максимальный элемент в массиве и поменять его местами с нулевым элементом
        int[] array4 = Arrays.copyOf(array, arrayLength);
        int maxElement = array4[0];
        int indexMaxElement = 0;
        for (int i = 1; i < arrayLength; i++) {
            if (array4[i] > maxElement) {
                maxElement = array4[i];
                indexMaxElement = i;
            }
        }
        int buff = array4[0];
        array4[0] = array4[indexMaxElement];
        array4[indexMaxElement] = buff;
        System.out.println(Arrays.toString(array4));

    }
}
