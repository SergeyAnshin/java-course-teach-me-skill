import interfaces.Convertible;
import interfaces.Loadable;
import interfaces.Measurable;

public abstract class Transport implements Convertible, Measurable, Loadable {
    private double power;
    private double maxSpeed;
    private double weight;
    private String brand;

    public Transport(double power, double maxSpeed, double weight, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void isItPossibleLoad(double somethingToBeLoaded) {}

    @Override
    public String toString() {
        return "power=" + power + " л.с., " + convertHorsePowerIntoKilowatt(power) + " kilowatt" +
                ", maxSpeed=" + maxSpeed + "км/ч" +
                ", weight=" + weight + " кг" +
                ", brand='" + brand + ", ";
    }
}
