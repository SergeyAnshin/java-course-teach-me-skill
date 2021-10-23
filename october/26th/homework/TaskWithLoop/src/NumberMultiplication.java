public class NumberMultiplication {
    private int firstMultiplier;
    private int secondMultiplier;

    public NumberMultiplication(int firstMultiplier, int secondMultiplier) {
        this.firstMultiplier = firstMultiplier;
        this.secondMultiplier = secondMultiplier;
    }

    public int getProductNumbersUsingForLoop() {
        int multiplicationResult = 0;
        for (int i = 0; i < secondMultiplier; i++) {
            multiplicationResult += firstMultiplier;
        }
        return multiplicationResult;
    }

    public int getProductNumbersUsingWhileLoop() {
        int multiplicationResult = 0;
        int numberTerms = 0;
        while (numberTerms < secondMultiplier) {
            multiplicationResult += firstMultiplier;
            numberTerms++;
        }
        return multiplicationResult;
    }

    public int getProductNumbersUsingDoWhileLoop() {
        int multiplicationResult = 0;
        int numberTerms = 0;
        do {
            multiplicationResult += firstMultiplier;
            numberTerms++;
        } while (numberTerms < secondMultiplier);
        return multiplicationResult;
    }
}
