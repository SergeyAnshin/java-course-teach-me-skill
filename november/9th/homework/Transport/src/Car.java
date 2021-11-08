import interfaces.Measurable;

public class Car extends LandTransport implements Measurable {
    private String bodyType;
    private int numberPassengers;
    private static final int NUMBER_KILOMETRES_PER_LITRES = 100;

    public Car(double power, double maxSpeed, double weight, String brand, int numberWheels,
               double fuelConsumption, String bodyType, int numberPassengers) {
        super(power, maxSpeed, weight, brand, numberWheels, fuelConsumption);
        this.bodyType = bodyType;
        this.numberPassengers = numberPassengers;
    }

    @Override
    public void printMessage(double travelTime) {
        double distance = determineDistance(travelTime, getMaxSpeed());
        System.out.println("За время " + travelTime + " ч, автомобиль " + getBrand() +
                " двигаясь с максимальной скоростью " + getMaxSpeed() + " км/ч " + "проедет "
                + distance + " км и израсходует " +
                getFuelConsumptionPerTrip(distance, getFuelConsumption()) + " литров топлива.");
    }

    private double getFuelConsumptionPerTrip(double distance, double fuelConsumption) {
        return distance * fuelConsumption / NUMBER_KILOMETRES_PER_LITRES;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() +
                "bodyType='" + bodyType + '\'' +
                ", numberPassengers=" + numberPassengers +
                '}';
    }
}
