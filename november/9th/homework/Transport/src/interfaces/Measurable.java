package interfaces;

public interface Measurable {
    int NUMBER_KILOMETRES_PER_LITRES = 100;

    default double determineDistance(double travelTime, double speed) {
        return travelTime * speed;
    }

    default double determineAmountBurnedFuel(double distance, double fuelConsumption) {
        return distance * fuelConsumption / NUMBER_KILOMETRES_PER_LITRES;
    }

    void printMessage(double travelTime);
}
