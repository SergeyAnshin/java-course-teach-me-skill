public class AthleteWorkout {
    private int firstDayDistance;
    private int dailyDistanceIncreasePercentage;
    private int numberTrainingDays;

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
        float increasePercentageAsDecimal = getPercentAsDecimal();
        float trainingDayDistance = firstDayDistance;
        for (int trainingDay = 2; trainingDay <= numberTrainingDays; trainingDay++) {
            trainingDayDistance *= increasePercentageAsDecimal;
            totalDistance += trainingDayDistance;
        }
        return totalDistance;
    }

    public float getTotalDistanceUsingWhileLoop() {
        float totalDistance = firstDayDistance;
        int trainingDay = 2;
        float increasePercentageAsDecimal = getPercentAsDecimal();
        float trainingDayDistance = firstDayDistance;
        while (trainingDay <= numberTrainingDays) {
            trainingDayDistance *= increasePercentageAsDecimal;
            totalDistance += trainingDayDistance;
            trainingDay++;
        }
        return totalDistance;
    }

    private float getPercentAsDecimal() {
        return (float) (100 + dailyDistanceIncreasePercentage) / 100;
    }

    public String printTotalDistance(float totalDistance) {
        return "Distance covered by the athlete in " + numberTrainingDays + " days = " + totalDistance;
    }
}
