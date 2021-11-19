package exceptions;

public class PriceNotSuitable extends Exception {

    public PriceNotSuitable() {
        super();
    }

    public PriceNotSuitable(String message) {
        super(message);
    }

    public PriceNotSuitable(String message, Throwable cause) {
        super(message, cause);
    }

    public PriceNotSuitable(Throwable cause) {
        super(cause);
    }

    protected PriceNotSuitable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
