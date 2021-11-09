package secondpartclass;

import java.util.Random;
import java.util.Scanner;

public abstract class Clothes {
    private boolean isPutOn;

    public Clothes(boolean isPutOn) {
        this.isPutOn = isPutOn;
    }

    public boolean isPutOn() {
        return isPutOn;
    }

    public void setPutOn(boolean putOn) {
        isPutOn = putOn;
    }

    abstract int getRandomNumber();

    abstract int getConsoleNumber();

    abstract void putClothesOn();

    abstract void takeOffClothes();
}
