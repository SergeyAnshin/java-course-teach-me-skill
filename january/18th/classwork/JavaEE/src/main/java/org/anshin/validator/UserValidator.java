package org.anshin.validator;

import static org.anshin.validator.ValidatorMessageConstant.*;

public class UserValidator extends AbstractValidator {
    public static final String FIELD_NAME_EMAIL = "email";
    public static final String FIELD_NAME_LOGIN = "login";
    public static final String FIELD_NAME_PASSWORD = "password";
    public static final String FIELD_NAME_KEYWORD = "keyword";
    public static final String FORMAT_EMAIL = ".+@.+\\..+";
    public static final int MIN_PASSWORD_LENGTH = 5;
    public static final int MAX_PASSWORD_LENGTH = 30;
    public static final String PASSWORD_LENGTH_ERROR_MESSAGE =
            "must be between " + MIN_PASSWORD_LENGTH + " and " + MAX_PASSWORD_LENGTH + " characters!";

    @Override
    public boolean isValidValueForField(String value, String field) {
        switch (field) {
            case FIELD_NAME_EMAIL:
                return emailIsValid(value);
            case FIELD_NAME_LOGIN:
                return loginIsValid(value);
            case FIELD_NAME_PASSWORD:
                return passwordIsValid(value);
            case FIELD_NAME_KEYWORD:
                return keywordIsValid(value);
            default:
                return false;
        }
    }

    private boolean keywordIsValid(String keyword) {
        if (isEmptyField(keyword)) {
            changeErrorMessageForFieldToNewOne("Keyword", ERROR_MESSAGE_EMPTY_FIELD);
            return false;
        }

        if (!valueIsInRequiredFormat(keyword, CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Keyword", ERROR_MESSAGE_MUST_CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS);
            return false;
        }

        return true;
    }

    public boolean emailIsValid(String email) {
        if (isEmptyField(email)) {
            changeErrorMessageForFieldToNewOne("Email", ERROR_MESSAGE_EMPTY_FIELD);
            return false;
        }

        if (!valueIsInRequiredFormat(email, FORMAT_EMAIL)) {
            changeErrorMessageForFieldToNewOne("Email", ERROR_MESSAGE_EMAIL_FORMAT);
            return false;
        }

        return true;
    }

    public boolean loginIsValid(String login) {
        if (isEmptyField(login)) {
            changeErrorMessageForFieldToNewOne("Login", ERROR_MESSAGE_EMPTY_FIELD);
            return false;
        }

        if (!valueIsInRequiredFormat(login, CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Login", ERROR_MESSAGE_MUST_CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS);
            return false;
        }

        return true;
    }

    public boolean passwordIsValid(String password) {
        if (isEmptyField(password)) {
            changeErrorMessageForFieldToNewOne("Password", ERROR_MESSAGE_EMPTY_FIELD);
            return false;
        }

        if (!isLengthValueBetween(password, MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH)) {
            changeErrorMessageForFieldToNewOne("Password", PASSWORD_LENGTH_ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
