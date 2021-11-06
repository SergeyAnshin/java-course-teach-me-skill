public class Truck extends LandTransport {
    private double liftingCapacity;

    public Truck(double power, double maxSpeed, double weight, String brand,
                 int numberWheels, double fuelConsumption, double liftingCapacity) {
        super(power, maxSpeed, weight, brand, numberWheels, fuelConsumption);
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public void isItPossibleLoad(double cargoToBeLoaded) {
        if (liftingCapacity >= cargoToBeLoaded) {
            System.out.println("Грузовик загружен");
        } else {
            System.out.println("Вам нужен грузовик побольше");
        }
    }

    @Override
    public String toString() {
        return "Truck{" + super.toString() +
                "liftingCapacity=" + liftingCapacity +
                '}';
    }
}
