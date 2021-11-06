package flights;

public class Plane implements Fly {


    @Override
    public void fly() {
        System.out.println("Самолет полетел");
    }
}
