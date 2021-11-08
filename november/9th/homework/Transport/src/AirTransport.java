public abstract class AirTransport extends Transport {
    private double wingspan;
    private double minTakeOffRunwayLength;

    public AirTransport(double power, double maxSpeed, double weight, String brand,
                        double wingspan, double minTakeOffRunwayLength) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minTakeOffRunwayLength = minTakeOffRunwayLength;
    }

    @Override
    public String toString() {
        return super.toString() +
                "wingspan=" + wingspan + " м" +
                ", minTakeOffRunwayLength=" + minTakeOffRunwayLength + ", ";
    }
}
