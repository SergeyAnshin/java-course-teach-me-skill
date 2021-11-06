public class CivilAirTransport extends AirTransport {
    private int numberPassengers;
    private boolean isBusinessClass;

    public CivilAirTransport(double power, double maxSpeed, double weight, String brand, double wingspan,
                             double minTakeOffRunwayLength, int numberPassengers, boolean isBusinessClass) {
        super(power, maxSpeed, weight, brand, wingspan, minTakeOffRunwayLength);
        this.numberPassengers = numberPassengers;
        this.isBusinessClass = isBusinessClass;
    }

    @Override
    public void isItPossibleLoad(double passengersToBeLoaded) {
        if (numberPassengers >= passengersToBeLoaded) {
            System.out.println("Самолет загружен");
        } else {
            System.out.println("Вам нужен самолет побольше");
        }
    }

    @Override
    public String toString() {
        return "CivilAirTransport{" + super.toString() +
                "numberPassengers=" + numberPassengers +
                ", isBusinessClass=" + isBusinessClass +
                '}';
    }
}
