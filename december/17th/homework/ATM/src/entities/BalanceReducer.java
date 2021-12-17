package entities;

public class BalanceReducer implements Runnable {
    private ATM atm;
    private Card card;
    private Manager manager;
    private double withdrawAmount;

    public BalanceReducer(ATM atm, Card card, Manager manager, double withdrawAmount) {
        this.atm = atm;
        this.card = card;
        this.manager = manager;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " writes off from the balance");
            System.out.println("Balance before withdrawal: ATM = " + atm.getBalance() + ", card = " + card.getBalance());

            manager.withdraw(atm, withdrawAmount);
            manager.withdraw(card, withdrawAmount);

            System.out.println("Balance after withdrawal: ATM = " + atm.getBalance() + ", card = " + card.getBalance());
        }
    }
}
