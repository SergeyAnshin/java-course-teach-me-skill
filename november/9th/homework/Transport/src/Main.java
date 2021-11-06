public class Main {
    public static void main(String[] args) {
        Car car = new Car(10d, 150d, 2000d, "AUDI", 4,
                3.4d, "SID", 5);
        car.printMessage(3);
        System.out.println(car);
        System.out.println();

        Truck truck = new Truck(50d, 80d, 4500d, "TESLA",
                8, 5.7d, 5);
        truck.isItPossibleLoad(8);
        System.out.println(truck);
        System.out.println();

        CivilAirTransport airTransport = new CivilAirTransport(15d, 800d, 10000d,
                "Airbus", 15.3d, 500d, 150, false);
        airTransport.isItPossibleLoad(151);
        System.out.println(airTransport);
        System.out.println();

        MilitaryAirTransport militaryAirTransport = new MilitaryAirTransport(444d, 784d,
                70000d, "Belka", 45d, 800d,
                false, 5);
        militaryAirTransport.catapult();
        militaryAirTransport.shoot();
        System.out.println(militaryAirTransport);
    }
}
