package exceptions;

public class SpeedNotSuitable extends Exception {

    public SpeedNotSuitable() {
        super();
    }

    public SpeedNotSuitable(String message) {
        super(message);
    }

    public SpeedNotSuitable(String message, Throwable cause) {
        super(message, cause);
    }

    public SpeedNotSuitable(Throwable cause) {
        super(cause);
    }

    protected SpeedNotSuitable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
