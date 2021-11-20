package exceptions;

public class NotEnoughFundsOnAccountException extends Exception {
    public NotEnoughFundsOnAccountException() {
        super();
    }

    public NotEnoughFundsOnAccountException(String message) {
        super(message);
    }
}
