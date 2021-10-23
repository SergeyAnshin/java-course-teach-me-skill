public class ConversionTable {
    private int lowerValueTable;
    private int topValueTable;
    private final float CENTIMETERS_TO_INCHES = 2.54f;

    public ConversionTable(int lowerValueTable, int topValueTable) {
        this.lowerValueTable = lowerValueTable;
        this.topValueTable = topValueTable;
    }

    public void printTableForConvertingInchesToCentimetersUsingForLoop() {
        System.out.println("For loop result: ");
        for (int inchValue = lowerValueTable; inchValue <= topValueTable; inchValue++) {
            System.out.println(inchValue + " inch = " + inchValue * CENTIMETERS_TO_INCHES);
        }
    }

    public void printTableForConvertingInchesToCentimetersUsingWhileLoop() {
        System.out.println("While loop result: ");
        int inchValue = lowerValueTable;
        while (inchValue <= topValueTable) {
            System.out.println(inchValue + " inch = " + inchValue * CENTIMETERS_TO_INCHES);
            inchValue++;
        }
    }
}
