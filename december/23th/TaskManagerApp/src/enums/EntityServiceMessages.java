package enums;

public enum EntityServiceMessages {
    SUCCESSFUL_SAVE_MESSAGE("successful" , "saved!"),
    SUCCESSFUL_UPDATE_MESSAGE("successful" , "updated!"),
    SUCCESSFUL_DELETE_MESSAGE("successful" ,"deleted!"),
    SUCCESSFUL_TRANSFER_MESSAGE("successful", "has been transferred!"),

    FAILED_SAVE_MESSAGE("failed" ,"cannot be saved!"),
    FAILED_UPDATE_MESSAGE("failed" ,"cannot be updated!"),
    FAILED_DELETE_MESSAGE("failed" ,"cannot be deleted!"),
    FAILED_EXIST_MESSAGE("failed", "already exist!"),
    FAILED_TRANSFER_MESSAGE("failed", "has not been transferred!");

    private String messageType;
    private String message;

    EntityServiceMessages(String messageType, String message) {
        this.messageType = messageType;
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getMessage() {
        return message;
    }

    public static boolean isSuccessfulMessage(EntityServiceMessages messages) {
        return messages.getMessageType().equals("successful");
    }
}
