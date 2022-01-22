package org.anshin.validators;

import static org.anshin.enums.ValidatorMessage.*;

public class UserValidator extends AbstractValidator {
    public static final int MIN_PASSWORD_LENGTH = 5;
    public static final int MAX_PASSWORD_LENGTH = 30;
    public static final String PASSWORD_LENGTH_ERROR_MESSAGE =
            "must be between " + MIN_PASSWORD_LENGTH + " and " + MAX_PASSWORD_LENGTH + " characters!";

    @Override
    public boolean isValidValueForField(String value, String field) {
        switch (field) {
            case "login":
                return loginIsValid(value);
            case "password":
                return passwordIsValid(value);
            default:
                return false;
        }
    }

    public boolean loginIsValid(String login) {
        if (isEmptyField(login)) {
            changeErrorMessageForFieldToNewOne("Login", EMPTY_FIELD_ERROR_MESSAGE.getMessage());
            return false;
        }

        if (!valueIsInRequiredFormat(login, CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Login", CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_ERROR_MESSAGE.getMessage());
            return false;
        }

        return true;
    }

    public boolean passwordIsValid(String password) {
        if (isEmptyField(password)) {
            changeErrorMessageForFieldToNewOne("Password", EMPTY_FIELD_ERROR_MESSAGE.getMessage());
            return false;
        }

        if (!isLengthValueBetween(password, MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH)) {
            changeErrorMessageForFieldToNewOne("Password", PASSWORD_LENGTH_ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
