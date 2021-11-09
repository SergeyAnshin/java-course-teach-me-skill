public class Main {
    public static void main(String[] args) {
        IStart shuttle = new Shuttle();
        IStart spaceX = new SpaceX();
        IStart dragon = new Dragon();

        Spaceport spaceport = new Spaceport();
        spaceport.launch(shuttle);
        System.out.println();
        spaceport.launch(spaceX);
        System.out.println();
        spaceport.launch(dragon);
    }
}
