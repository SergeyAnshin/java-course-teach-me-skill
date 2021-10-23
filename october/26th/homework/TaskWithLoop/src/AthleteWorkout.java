public class AthleteWorkout {
    private int firstDayDistance;
    private int dailyDistanceIncreasePercentage;
    private int numberTrainingDays;
    private int dayStartGrowthDistance;

    {
        dayStartGrowthDistance = 2;
    }

    public AthleteWorkout(int firstDayDistance, int dailyDistanceIncreasePercentage, int numberTrainingDays) {
        this.firstDayDistance = firstDayDistance;
        this.dailyDistanceIncreasePercentage = dailyDistanceIncreasePercentage;
        this.numberTrainingDays = numberTrainingDays;
    }

    public int getNumberTrainingDays() {
        return numberTrainingDays;
    }

    public float getTotalDistanceUsingForLoop() {
        float totalDistance = firstDayDistance;
        float trainingDayDistance = firstDayDistance;
        float increasePercentageAsDecimal = getPercentageAsDecimal();
        for (int trainingDay = dayStartGrowthDistance; trainingDay <= numberTrainingDays; trainingDay++) {
            trainingDayDistance *= increasePercentageAsDecimal;
            totalDistance += trainingDayDistance;
        }
        return totalDistance;
    }

    public float getTotalDistanceUsingWhileLoop() {
        float totalDistance = firstDayDistance;
        int trainingDay = dayStartGrowthDistance;
        float trainingDayDistance = firstDayDistance;
        float increasePercentageAsDecimal = getPercentageAsDecimal();
        while (trainingDay <= numberTrainingDays) {
            trainingDayDistance *= increasePercentageAsDecimal;
            totalDistance += trainingDayDistance;
            trainingDay++;
        }
        return totalDistance;
    }

    public float getTotalDistanceUsingDoWhileLoop() {
        float totalDistance = firstDayDistance;
        int trainingDay = dayStartGrowthDistance;
        float trainingDayDistance = firstDayDistance;
        float increasePercentageAsDecimal = getPercentageAsDecimal();
        do {
            trainingDayDistance *= increasePercentageAsDecimal;
            totalDistance += trainingDayDistance;
            trainingDay++;
        } while (trainingDay <= numberTrainingDays);
        return totalDistance;
    }

    private float getPercentageAsDecimal() {
        return (float) (100 + dailyDistanceIncreasePercentage) / 100;
    }

    public String printTotalDistance(float totalDistance) {
        return "Distance covered by the athlete in " + numberTrainingDays + " days = " + totalDistance;
    }
}
