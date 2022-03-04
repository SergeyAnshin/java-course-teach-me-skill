package org.sergey.ans.exception;

public class UserAlreadyException extends RuntimeException {

    public UserAlreadyException() {
        super();
    }

    public UserAlreadyException(String message) {
        super(message);
    }

    public UserAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyException(Throwable cause) {
        super(cause);
    }

    protected UserAlreadyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
