import secondpartclass.Hat;
import secondpartclass.Human;
import secondpartclass.Jacket;
import secondpartclass.Pants;

import java.net.HttpURLConnection;

public class Main {
    public static void main(String[] args) {
        Hat hat = new Hat(true);
        hat.putClothesOn();
        hat.takeOffClothes();

        Jacket jacket = new Jacket(true);
        jacket.putClothesOn();
        jacket.takeOffClothes();

        Pants pants = new Pants(true);
        pants.putClothesOn();
        pants.takeOffClothes();

        Human human = new Human(hat, jacket, pants);
        human.putOnAllClothes();
        human.takeOffAllClothes();

    }
}
