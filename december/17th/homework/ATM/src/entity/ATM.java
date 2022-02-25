package entity;

import java.util.Objects;

public class ATM implements Entity {
    private int id;
    private boolean isWorking;
    private double balance;
    private Card card;

    public ATM() {
    }

    public ATM(int id, boolean isWorking, double balance, Card card) {
        this.id = id;
        this.isWorking = isWorking;
        this.balance = balance;
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return id == atm.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id=" + id +
                ", isWorking=" + isWorking +
                ", balance=" + balance +
                ", card=" + card +
                '}';
    }
}
