package org.anshin.enums;

public enum ServiceMessage {
    SUCCESSFUL_REGISTRATION_MESSAGE("successful", "You are registered!"),
    SUCCESSFUL_SAVE_MESSAGE("successful" , "saved!"),
    SUCCESSFUL_AUTHENTICATION_MESSAGE("successful", "You are logged in!"),
    SUCCESSFUL_LOG_OUT_MESSAGE("successful", "You logged out!"),

    FAILED_REGISTRATION_MESSAGE("failed", "Registration failed!"),
    FAILED_SAVE_MESSAGE("failed" ,"cannot be saved!"),
    FAILED_EXISTS_MESSAGE("failed" ,"already exists!"),
    FAILED_AUTHENTICATION_MESSAGE("failed", "There is no user with this username and password!");

    private String messageType;
    private String message;

    ServiceMessage(String messageType, String message) {
        this.messageType = messageType;
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getMessage() {
        return message;
    }

    public static boolean isSuccessfulMessage(ServiceMessage messages) {
        return messages.getMessageType().equals("successful");
    }
}
