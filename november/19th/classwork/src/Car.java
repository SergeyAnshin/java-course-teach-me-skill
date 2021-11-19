import exceptions.MarkNotSuitable;
import exceptions.PriceNotSuitable;
import exceptions.SpeedNotSuitable;

public class Car {
    private double price;
    private double maxSpeed;
    private String mark;
    private User potentialBuyer;

    public Car() {
    }

    public Car(double price, double maxSpeed, String mark, User potentialBuyer) {
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.mark = mark;
        this.potentialBuyer = potentialBuyer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void isPriceSuitableForBuyer() throws PriceNotSuitable {
        if (price > potentialBuyer.getRequiredMaxPrice()) {
            throw new PriceNotSuitable("Car price is higher then required by " +
                    (maxSpeed - potentialBuyer.getRequiredMaxPrice()));
        } else {
            System.out.println("Price is well");
        }
    }

    public void isMaxSpeedSuitableForBuyer() throws SpeedNotSuitable {
        if (maxSpeed < potentialBuyer.getRequiredMaxSpeed()) {
            throw new SpeedNotSuitable("Car speed is less then required by " +
                    (potentialBuyer.getRequiredMaxSpeed() - maxSpeed));
        } else {
            System.out.println("Speed is well");
        }
    }

    public void isMarkSuitableForBuyer() throws MarkNotSuitable {
        if (!potentialBuyer.getRequiredMark().contains(mark)) {
            throw new MarkNotSuitable("Car mark is not suitable");
        } else {
            System.out.println("Mark is well");
        }
    }
}
