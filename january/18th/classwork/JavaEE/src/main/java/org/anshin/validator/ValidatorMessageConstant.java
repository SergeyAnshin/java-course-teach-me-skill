package org.anshin.validator;

import org.anshin.enums.Operation;

import java.util.Arrays;

public class ValidatorMessageConstant {
    public static final String ERROR_MESSAGE_NO_VALIDATOR_FOR_FIELD = "There isn't validator for field!";

    public static final String ERROR_MESSAGE_EMPTY_FIELD = "must not be empty!";

    public static final String ERROR_MESSAGE_MUST_CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS
            = "must contain only latin numbers or letters!";

    public static final String ERROR_MESSAGE_MUST_CONTAIN_ONLY_NUMBERS = "must contain only numbers!";

    public static final String ERROR_MESSAGE_OPERATION_DOES_NOT_EXIST
            = "does not exist. The app only supports these operations " +Arrays.toString(Operation.values());

    public static final String ERROR_MESSAGE_EMAIL_FORMAT = "must be in format ____@___.__ !";

}
