import exceptions.NotEnoughFundsOnAccountException;
import exceptions.WrongCardTypeException;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

public class ATM {
    private double totalMoney;
    private boolean isWorking;
    private List<CardType> supportedCardTypes;
    private HashMap<Integer, String> menu = new HashMap<>(Map.of(1, "Withdraw money", 2, "Account balance", 3, "Exit"));

    {
        isWorking = true;
    }

    public ATM() {
    }

    public ATM(double totalMoney, List<CardType> supportedCardTypes) {
        this.totalMoney = totalMoney;
        this.supportedCardTypes = supportedCardTypes;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public List<CardType> getSupportedCardTypes() {
        return supportedCardTypes;
    }

    public void setSupportedCardTypes(List<CardType> supportedCardTypes) {
        this.supportedCardTypes = supportedCardTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return Double.compare(atm.totalMoney, totalMoney) == 0 && isWorking == atm.isWorking && supportedCardTypes.equals(atm.supportedCardTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalMoney, isWorking, supportedCardTypes);
    }

    @Override
    public String toString() {
        return "ATM{" +
                "totalMoney=" + totalMoney +
                ", isWorking=" + isWorking +
                ", supportedCardTypes=" + supportedCardTypes +
                '}';
    }


    public void start(Card card) {
        try {
            if (isBankCardSupported(card)) {
                while (true) {
                    showMenu();
                    performActionOn(card);
                }
            } else {
                throw new WrongCardTypeException(card.getCardType() +
                        " card not supported. ATM supports only " +
                        supportedCardTypes.toString() + " cards");
            }
        } catch (NullPointerException | WrongCardTypeException | NotEnoughFundsOnAccountException exception) {
            exception.printStackTrace();
        }
    }

    private boolean isBankCardSupported(Card card) throws NullPointerException {
        return supportedCardTypes.contains(card.getCardType());
    }

    private void showMenu() {
        menu.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    private void performActionOn(Card card) throws NotEnoughFundsOnAccountException {
        int actionNumber = getActionNumber();
        if (actionNumber == 1) {
            writeOffMoneyFrom(card);
        } else if (actionNumber == 2) {
            System.out.println(card.getCardFunds());
        } else {
            System.exit(0);
        }
    }

    private int getActionNumber() {
        int actionNumber;
        double number;
        while (true) {
            System.out.print("Select menu item: ");
            number = getNumber();
            if (number <= 3 && number % 1 == 0) {
                actionNumber = (int) number;
                break;
            }
        }
        return actionNumber;
    }

    private void writeOffMoneyFrom(Card card) throws NotEnoughFundsOnAccountException {
        double amountMoneyToWriteOff = getAmountMoneyToWithdraw();
        if (card.thereAreFundsOnCardToWriteOff(amountMoneyToWriteOff)) {
            totalMoney -= amountMoneyToWriteOff;
            card.setCardFunds(card.getCardFunds() - amountMoneyToWriteOff);
        } else {
            throw new NotEnoughFundsOnAccountException("Not enough money on the card to write off");
        }
    }

    private double getAmountMoneyToWithdraw() {
        System.out.print("Enter the amount to be withdrawn from the card: ");
        return getNumber();
    }

    private double getNumber() {
        Scanner scanner = new Scanner(System.in);
        String number;
        while (true) {
            if (scanner.hasNextLine()) {
                number = scanner.nextLine();
                if (!number.isBlank() && NumberUtils.isCreatable(number) && Double.parseDouble(number) >= 1) {
                    return Double.parseDouble(number);
                }
            } else {
                scanner.next();
            }
        }
    }
}
