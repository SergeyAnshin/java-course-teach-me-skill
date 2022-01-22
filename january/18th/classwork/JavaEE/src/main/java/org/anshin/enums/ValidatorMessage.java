package org.anshin.enums;

import java.util.Arrays;

public enum ValidatorMessage {
    NO_VALIDATOR_FOR_FIELD_ERROR_MESSAGE("There isn't validator for field!"),
    EMPTY_FIELD_ERROR_MESSAGE("must not be empty!"),
    CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_ERROR_MESSAGE("must contain only latin numbers or letters!"),
    CONTAIN_ONLY_NUMBERS_MESSAGE("must contain only numbers!"),
    OPERATION_DOES_NOT_EXIST_MESSAGE("does not exist. The app only supports these operations " + Arrays.toString(Operation.values())),
    EMAIL_FORMAT_ERROR_MESSAGE("must be in format ____@___.__ !");

    private String message;

    ValidatorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
