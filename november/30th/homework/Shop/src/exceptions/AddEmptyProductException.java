package exceptions;

public class AddEmptyProductException extends Exception {
    public AddEmptyProductException() {
        super();
    }

    public AddEmptyProductException(String message) {
        super(message);
    }
}
