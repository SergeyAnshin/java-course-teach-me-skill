package org.anshin.enums;

public enum ValidatorMessage {
    NO_VALIDATOR_FOR_FIELD_ERROR_MESSAGE("There isn't validator for field!"),
    EMPTY_FIELD_ERROR_MESSAGE("must not be empty!"),
    CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_ERROR_MESSAGE("must contain only latin numbers or letters!"),
    EMAIL_FORMAT_ERROR_MESSAGE("must be in format ____@___.__ !");

    private String message;

    ValidatorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
