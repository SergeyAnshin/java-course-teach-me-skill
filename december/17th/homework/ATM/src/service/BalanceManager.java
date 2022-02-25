package service;

import entity.Entity;

public class BalanceManager {

    public void topUp(Entity entity, double amount) {
        synchronized (entity) {
            double currentEntityBalance = entity.getBalance();
            entity.setBalance(currentEntityBalance + amount);
        }
    }

    public void withdraw(Entity entity, double amount) {
        synchronized (entity) {
            if (isThereEnoughMoneyToWithdraw(entity, amount)) {
                double currentEntityBalance = entity.getBalance();
                entity.setBalance(currentEntityBalance - amount);
            } else {
                System.out.println("No money");
            }
        }
    }

    public boolean isThereEnoughMoneyToWithdraw(Entity entity, double amount) {
        return entity.getBalance() >= amount;
    }
}
