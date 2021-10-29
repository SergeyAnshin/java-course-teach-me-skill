import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int[][] array = new int[4][4];
//        Random random = new Random();
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                array[i][j] = random.nextInt(50);
//            }
//        }
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(Arrays.toString(array[i]));
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i][array.length - i - 1]);
//        }




        Random random = new Random();
        int arrayLength = 4;
        int[][] array = new int[arrayLength][arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                array[i][j] = random.nextInt(50);
            }
        }
        for (int i = 0; i < arrayLength; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();

//        First task - Почитать сумму четных элементов стоящих на главной диагонали.
        int sumEvenElementMainDiagonal = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i][i] % 2 == 0) {
                sumEvenElementMainDiagonal += array[i][i];
            }
        }
        System.out.println(sumEvenElementMainDiagonal);
        System.out.println();

//        Second task - Вывести нечетные элементы находящиеся под главной диагональю(включительно).
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                if (i >= j && array[i][j] % 2 != 0) {
                    System.out.print(array[i][j] + " ");
                }
            }
        }
        System.out.println();
        System.out.println();

//        Third task - Проверить произведение элементов какой диагонали больше
        int productElementsMainDiagonal = 1;
        int productElementsSecondDiagonal = 1;
        for (int i = 0; i < arrayLength; i++) {
            productElementsMainDiagonal *= array[i][i];
            productElementsSecondDiagonal *= array[i][arrayLength - 1 - i];
        }
        System.out.println(productElementsMainDiagonal > productElementsSecondDiagonal ? "main" : "second");
        System.out.println();

//        Fourth task - Посчитать сумму четных элементов стоящих над побочной диагональю (не  включительно)
        int sumElements = 0;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                if (i < j && array[i][j] % 2 == 0) {
                    sumElements += array[i][j];
                }
            }
        }
        System.out.println(sumElements);
        System.out.println();

//        Fifth task - Транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-йстрокой и т. д.)
        int k = 0;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = k; j < arrayLength; j++) {
                if (i != j) {
                    int buff = array[i][j];
                    array[i][j] = array[j][i];
                    array[j][i] = buff;
                }
            }
            k++;
        }
        for (int i = 0; i < arrayLength; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
