package entities;

public class BalanceIncreaser implements Runnable {
    private ATM atm;
    private Card card;
    private Manager manager;
    private double topUpAmount;

    public BalanceIncreaser(ATM atm, Card card, Manager manager, double topUpAmount) {
        this.atm = atm;
        this.card = card;
        this.manager = manager;
        this.topUpAmount = topUpAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " top-up balance");
            System.out.println("Balance before top-up: ATM = " + atm.getBalance() + ", card = " + card.getBalance());

            manager.topUp(atm, topUpAmount);
            manager.topUp(card, topUpAmount);

            System.out.println("Balance after top-up: ATM = " + atm.getBalance() + ", card = " + card.getBalance());
        }
    }
}
