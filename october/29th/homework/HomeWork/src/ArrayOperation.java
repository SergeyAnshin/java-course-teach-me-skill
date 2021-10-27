import java.util.Random;

public class ArrayOperation {

    public static int[] createArrayEvenOrOddNumbers(int fromNumber, int toNumber, boolean evenNumbers) {
        int[] array;
        int firstNumber;
        if (evenNumbers) {
            array = new int[getNumberEvenNumbersBetween(fromNumber, toNumber)];
            firstNumber = getFirstEvenAndOddNumber(fromNumber)[0];
        } else {
            array = new int[getNumberOddNumbersBetween(fromNumber, toNumber)];
            firstNumber = getFirstEvenAndOddNumber(fromNumber)[1];
        }
        for (int i = 0, j = firstNumber; i < array.length; i++, j += 2) {
            array[i] = j;
        }
        return array;
    }

    private static int[] getFirstEvenAndOddNumber(int number) {
        int[] firstEvenAndOddNumber = new int[2];
        if (isItEvenNumber(number)) {
            firstEvenAndOddNumber[0] = number;
            firstEvenAndOddNumber[1] = number + 1;
        } else {
            firstEvenAndOddNumber[1] = number;
            firstEvenAndOddNumber[0] = number + 1;
        }
        return firstEvenAndOddNumber;
    }

    private static boolean isItEvenNumber(int number) {
        return number % 2 == 0;
    }

    private static int getNumberEvenNumbersBetween(int fromNumber, int toNumber) {
        if (!isItEvenNumber(fromNumber) && !isItEvenNumber(toNumber)) {
            return Math.abs(fromNumber - toNumber) / 2;
        } else {
            return Math.abs(fromNumber - toNumber) / 2 + 1;
        }
    }

    private static int getNumberOddNumbersBetween(int fromNumber, int toNumber) {
        if (isItEvenNumber(fromNumber) && isItEvenNumber(toNumber)) {
            return Math.abs(fromNumber - toNumber) / 2;
        } else {
            return Math.abs(fromNumber - toNumber) / 2 + 1;
        }
    }

    public static int[] createArrayRandomNumbersBetween(int fromNumber, int toNumber, int numberRandomElements) {
        int[] array = new int[numberRandomElements];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt((toNumber - fromNumber) + 1) + fromNumber;
        }
        return array;
    }

    public static void replaceArrayElements(int[] array, boolean oddIndex, int replacementValues) {
        int replacementIndex = oddIndex ? 1 : 0;
        for (int i = replacementIndex; i < array.length; i += 2) {
            array[i] = replacementValues;
        }
    }

    private static double getAverageElementsArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / array.length;
    }

    public static void compareArithmeticMeanArrayElements(int[] firstArray, int[] secondArray){
        double averageFirstArray = getAverageElementsArray(firstArray);
        double averageSecondArray = getAverageElementsArray(secondArray);
        if (averageFirstArray > averageSecondArray) {
            System.out.println("The average of the first array is greater");
        } else if (averageFirstArray < averageSecondArray) {
            System.out.println("The average of the second array is greater");
        } else {
            System.out.println("Average are equal");
        }
    }

    public static int getNumberEvenNumbersInArray(int[] array) {
        int numberEvenNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            if (isItEvenNumber(array[i])) {
                numberEvenNumbers += 1;
            }
        }
        return numberEvenNumbers;
    }

    public static String isArraySortedInAscendingOrder(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                flag = false;
                break;
            }
        }
        String result = flag ? "The array is sorted in ascending order" : "Array is not sorted in ascending order";
        return result;
    }

    public static double[] getArrayQuotientElementsArrays(int[] firstArray, int[] secondArray) {
        double[] array = new double[firstArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            array[i] = (double) firstArray[i]/secondArray[i];
        }
        return array;
    }

    public static int getNumberIntegers(double[] array) {
        int numberIntegers = 0;
        for (int i = 0; i < array.length; i++) {
           if (array[i] % 1 == 0) {
               numberIntegers += 1;
           }
        }
        return numberIntegers;
    }

    public static int getIndexLastMaxValue(int[] array) {
        int indexLastMaxValue = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[indexLastMaxValue] <= array[i]) {
                indexLastMaxValue = i;
            }
        }
        return indexLastMaxValue;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int buff = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buff;
                }
            }
        }
    }

    public static void printArraySeparatedBySpace(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printDoubleArraySeparatedBySpace(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printArrayToColumn(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArrayInReverseOrder(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

}
