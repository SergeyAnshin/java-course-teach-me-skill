import entities.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Person owner = new Person();
        Card card = new Card(123456789L, owner, 2000d);
        ATM atm = new ATM(0, true, 20000d, card);
        Manager manager = new Manager();

        BalanceReducer balanceReducer = new BalanceReducer(atm, card, manager, 100);
        BalanceIncreaser balanceIncreaser = new BalanceIncreaser(atm, card, manager, 100);

        Thread topUpThread = new Thread(balanceIncreaser);
        Thread withdrawThread = new Thread(balanceReducer);
        topUpThread.start();
        withdrawThread.start();
    }
}
