package service;

import entity.ATM;
import entity.Card;

public class BalanceReducer implements Runnable {
    private ATM atm;
    private Card card;
    private BalanceManager balanceManager;
    private double withdrawAmount;

    public BalanceReducer(ATM atm, Card card, BalanceManager balanceManager, double withdrawAmount) {
        this.atm = atm;
        this.card = card;
        this.balanceManager = balanceManager;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " writes off from the balance");
            System.out.println("Balance before withdrawal: ATM = " + atm.getBalance() + ", card = " + card.getBalance());

            balanceManager.withdraw(atm, withdrawAmount);
            balanceManager.withdraw(card, withdrawAmount);

            System.out.println("Balance after withdrawal: ATM = " + atm.getBalance() + ", card = " + card.getBalance());
        }
    }
}
