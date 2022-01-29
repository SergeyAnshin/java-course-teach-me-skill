package org.anshin.validator;

import java.util.regex.Pattern;

public abstract class AbstractValidator {
    private String errorMessage;
    public static final String CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_FORMAT = "^[a-zA-Z0-9]*$";
    public static final String NUMBER_FORMAT = "^[-+]?\\d*[.,]?\\d+(?:[eE][-+]?\\d+)?$";

    public AbstractValidator() {}

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public abstract boolean isValidValueForField(String value, String field);

    public boolean isLengthValueBetween(String value, int minLength, int maxLength) {
        return value.length() >= minLength && value.length() <= maxLength;
    }

    public void changeErrorMessageForFieldToNewOne(String field, String newErrorMessage) {
        setErrorMessage(field + " " + newErrorMessage);
    }

    public boolean valueIsInRequiredFormat(String value, String format) {
        return Pattern.compile(format).matcher(value).find();
    }

    public boolean isEmptyField(String field) {
        return field == null || field.isBlank();
    }
}
