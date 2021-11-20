package exceptions;

public class WrongCardTypeException extends Exception {

    public WrongCardTypeException() {
        super();
    }

    public WrongCardTypeException(String message) {
        super(message);
    }
}
