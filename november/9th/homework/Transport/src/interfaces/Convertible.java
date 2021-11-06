package interfaces;

public interface Convertible {
    double NUMBER_KILOWATT_IN_HORSE_POWER = 0.74d;

    default double convertHorsePowerIntoKilowatt(double numberHorsePower) {
        return numberHorsePower * NUMBER_KILOWATT_IN_HORSE_POWER;
    }
}
