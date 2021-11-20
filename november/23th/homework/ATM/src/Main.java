import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        ATM atm = new ATM(10000d, List.of(CardType.CREDIT, CardType.DEBIT));
        Card card = new Card(CardType.CREDIT, 9379992, user, 0);
        atm.start(card);
    }
}
