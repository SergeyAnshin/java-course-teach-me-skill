public abstract class LandTransport extends Transport {
    private int numberWheels;
    private double fuelConsumption;

    public LandTransport(double power, double maxSpeed, double weight, String brand,
                         int numberWheels, double fuelConsumption) {
        super(power, maxSpeed, weight, brand);
        this.numberWheels = numberWheels;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public void printMessage(double travelTime) {}

    @Override
    public String toString() {
        return super.toString() +
                "numberWheels=" + numberWheels +
                ", fuelConsumption=" + fuelConsumption + " л/100км, ";
    }
}
