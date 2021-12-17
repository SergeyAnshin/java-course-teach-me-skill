package entities;

import java.util.Objects;

public class Card implements Entity {
    private long number;
    private Person cardOwner;
    private double balance;

    public Card() {
    }

    public Card(long number, Person cardOwner, double balance) {
        this.number = number;
        this.cardOwner = cardOwner;
        this.balance = balance;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Person getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(Person cardOwner) {
        this.cardOwner = cardOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", cardOwner=" + cardOwner +
                ", balance=" + balance +
                '}';
    }
}
