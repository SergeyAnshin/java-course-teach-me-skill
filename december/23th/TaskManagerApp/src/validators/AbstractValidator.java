package validators;

import concole.ConsoleColors;

import java.util.regex.Pattern;

public abstract class AbstractValidator<T> {
    public static final String NO_VALIDATOR_FOR_FIELD_ERROR_MESSAGE = "There isn't validator for field";
    public static final String EMPTY_FIELD_ERROR_MESSAGE = "must not be empty!";
    public static final String CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_FORMAT = "^[a-zA-Z0-9]*$";
    public static final String CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_ERROR_MESSAGE =
            "must contain only latin numbers or letters!";

    private String errorMessage;

    public AbstractValidator() {}

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public abstract boolean isValid(T something);

    public abstract boolean isValidValueForField(String value, String field);

    public boolean isLengthValueBetween(String value, int minLength, int maxLength) {
        return value.length() >= minLength && value.length() <= maxLength;
    }

    public void changeErrorMessageForFieldToNewOne(String field, String newErrorMessage) {
        setErrorMessage(ConsoleColors.RED + field + " " + newErrorMessage + ConsoleColors.RESET);
    }

    public boolean fieldIsInRequiredFormat(String field, String format) {
        return Pattern.compile(format).matcher(field).find();
    }

    public boolean isEmptyField(String field) {
        return field == null || field.isBlank();
    }
}
