package secondpartclass;

public class Human {
    private Hat hat;
    private Jacket jacket;
    private Pants pants;

    public Human(Hat hat, Jacket jacket, Pants pants) {
        this.hat = hat;
        this.jacket = jacket;
        this.pants = pants;
    }

    public void putOnAllClothes(){
        hat.setPutOn(true);
        jacket.setPutOn(true);
        pants.setPutOn(true);
    }

    public void takeOffAllClothes(){
        hat.setPutOn(false);
        jacket.setPutOn(false);
        pants.setPutOn(false);
    }
}
