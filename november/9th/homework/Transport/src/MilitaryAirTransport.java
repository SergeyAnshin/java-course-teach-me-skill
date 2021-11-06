import interfaces.Shootable;

public class MilitaryAirTransport extends AirTransport implements Shootable {
    private boolean isEjectionSystem = true;
    private int numberRockets;

    public MilitaryAirTransport(double power, double maxSpeed, double weight, String brand, double wingspan,
                                double minTakeOffRunwayLength, boolean isEjectionSystem, int numberRockets) {
        super(power, maxSpeed, weight, brand, wingspan, minTakeOffRunwayLength);
        this.isEjectionSystem = isEjectionSystem;
        this.numberRockets = numberRockets;
    }

    @Override
    public void shoot() {
        if (numberRockets > 0) {
            System.out.println("Ракета пошла");
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    public void catapult() {
        if (isEjectionSystem) {
            System.out.println("Катапультирование прошло успешно");
        } else {
            System.out.println("У вас нет такой системы");
        }
    }

    @Override
    public String toString() {
        return "MilitaryAirTransport{" + super.toString() +
                "isEjectionSystem=" + isEjectionSystem +
                ", numberRockets=" + numberRockets +
                '}';
    }
}
