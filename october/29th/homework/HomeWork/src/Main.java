public class Main {

    public static void main(String[] args) {
//        // 1
//        int[] arrayEvenNumbers = ArrayOperation.createArrayEvenOrOddNumbers(0, 20, true);
//        ArrayOperation.printArraySeparatedBySpace(arrayEvenNumbers);
//        ArrayOperation.printArrayToColumn(arrayEvenNumbers);
//
//        // 2
//        int[] arrayOddNumbers = ArrayOperation.createArrayEvenOrOddNumbers(0, 99, false);
//        ArrayOperation.printArraySeparatedBySpace(arrayOddNumbers);
//        System.out.println();
//        ArrayOperation.printArrayInReverseOrder(arrayOddNumbers);
//
//        // 3
//        int[] array = ArrayOperation.createArrayRandomNumbersBetween(0,99, 15);
//        ArrayOperation.printArraySeparatedBySpace(array);
//        System.out.println();
//        System.out.println(ArrayOperation.getNumberEvenNumbersInArray(array));
//
//        // 4
//        int[] arrayRandomNumbers = ArrayOperation.createArrayRandomNumbersBetween(0, 20, 20);
//        ArrayOperation.printArraySeparatedBySpace(arrayRandomNumbers);
//        ArrayOperation.replaceArrayElements(arrayRandomNumbers, true, 0);
//        System.out.println();
//        ArrayOperation.printArraySeparatedBySpace(arrayRandomNumbers);
//
//        // 5
//        int[] firstArrayRandomNumbers = ArrayOperation.createArrayRandomNumbersBetween(0, 15, 5);
//        int[] secondArrayRandomNumbers = ArrayOperation.createArrayRandomNumbersBetween(0, 15, 5);
//        ArrayOperation.printArraySeparatedBySpace(firstArrayRandomNumbers);
//        System.out.println();
//        ArrayOperation.printArraySeparatedBySpace(secondArrayRandomNumbers);
//        System.out.println();
//        ArrayOperation.compareArithmeticMeanArrayElements(firstArrayRandomNumbers, secondArrayRandomNumbers);
//
//        // 6
//        int[] randomNumbers = ArrayOperation.createArrayRandomNumbersBetween(0, 10, 4);
//        ArrayOperation.printArraySeparatedBySpace(randomNumbers);
//        System.out.println();
//        System.out.println(ArrayOperation.isArraySortedInAscendingOrder(randomNumbers));
//
//        // 7
//        int[] randomArrayWithMax = ArrayOperation.createArrayRandomNumbersBetween(0, 15, 12);
//        ArrayOperation.printArraySeparatedBySpace(randomArrayWithMax);
//        System.out.println();
//        System.out.println(ArrayOperation.getIndexLastMaxValue(randomArrayWithMax));
//
//        // 8
//        int[] firstRandomNumbers = ArrayOperation.createArrayRandomNumbersBetween(0,9, 10);
//        int[] secondRandomNumbers = ArrayOperation.createArrayRandomNumbersBetween(0,9, 10);
//        double[] thirdArray = ArrayOperation.getArrayQuotientElementsArrays(firstRandomNumbers, secondRandomNumbers);
//        ArrayOperation.printArraySeparatedBySpace(firstRandomNumbers);
//        System.out.println();
//        ArrayOperation.printArraySeparatedBySpace(secondRandomNumbers);
//        System.out.println();
//        ArrayOperation.printDoubleArraySeparatedBySpace(thirdArray);
//        System.out.println();
//        System.out.println(ArrayOperation.getNumberIntegers(thirdArray));

        // 9
        int[] arrayForSort = ArrayOperation.createArrayRandomNumbersBetween(0, 20, 15);
        ArrayOperation.printArraySeparatedBySpace(arrayForSort);
        ArrayOperation.bubbleSort(arrayForSort);
        System.out.println();
        ArrayOperation.printArraySeparatedBySpace(arrayForSort);

    }
}
