package service;

import entity.ATM;
import entity.Card;

public class BalanceIncreaser implements Runnable {
    private ATM atm;
    private Card card;
    private BalanceManager balanceManager;
    private double topUpAmount;

    public BalanceIncreaser(ATM atm, Card card, BalanceManager balanceManager, double topUpAmount) {
        this.atm = atm;
        this.card = card;
        this.balanceManager = balanceManager;
        this.topUpAmount = topUpAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " top-up balance");
            System.out.println("Balance before top-up: ATM = " + atm.getBalance() + ", card = " + card.getBalance());

            balanceManager.topUp(atm, topUpAmount);
            balanceManager.topUp(card, topUpAmount);

            System.out.println("Balance after top-up: ATM = " + atm.getBalance() + ", card = " + card.getBalance());
        }
    }
}
