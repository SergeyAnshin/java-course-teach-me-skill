import java.util.Objects;

public class Card {
    private CardType cardType;
    private int cardNumber;
    private User cardFounder;
    private double cardFunds;

    public Card() {
    }

    public Card(CardType cardType, int cardNumber, User cardFounder, double cardFunds) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardFounder = cardFounder;
        this.cardFunds = cardFunds;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public User getCardFounder() {
        return cardFounder;
    }

    public void setCardFounder(User cardFounder) {
        this.cardFounder = cardFounder;
    }

    public double getCardFunds() {
        return cardFunds;
    }

    public void setCardFunds(double cardFunds) {
        this.cardFunds = cardFunds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNumber == card.cardNumber && Double.compare(card.cardFunds, cardFunds) == 0 && cardType == card.cardType && cardFounder.equals(card.cardFounder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardNumber, cardFounder, cardFunds);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardType=" + cardType +
                ", cardNumber=" + cardNumber +
                ", cardFounder=" + cardFounder +
                ", cardFunds=" + cardFunds +
                '}';
    }

    public boolean thereAreFundsOnCardToWriteOff(double amountMoneyToWriteOff) {
        return (cardFunds - amountMoneyToWriteOff) >= 0;
    }
}
