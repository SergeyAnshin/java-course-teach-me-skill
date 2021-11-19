package exceptions;

public class MarkNotSuitable extends Exception {

    public MarkNotSuitable() {
        super();
    }

    public MarkNotSuitable(String message) {
        super(message);
    }

    public MarkNotSuitable(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkNotSuitable(Throwable cause) {
        super(cause);
    }

    protected MarkNotSuitable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
