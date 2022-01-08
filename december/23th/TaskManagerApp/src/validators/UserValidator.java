package validators;

import concole.ConsoleColors;
import entities.User;
import services.UserService;
import services.impl.UserServiceImpl;

public class UserValidator extends AbstractValidator<User> {
    private UserService<User> userService = new UserServiceImpl();

    public static final int MIN_PASSWORD_LENGTH = 5;
    public static final int MAX_PASSWORD_LENGTH = 30;

    public static final String EMAIL_FORMAT = ".+@.+\\..+";
    public static final String EMAIL_FORMAT_ERROR_MESSAGE = "must be in format ____@___.__ !";

    public static final String PASSWORD_LENGTH_ERROR_MESSAGE =
            "must be between " + MIN_PASSWORD_LENGTH + " and " + MAX_PASSWORD_LENGTH + " characters";

    @Override
    public boolean isValid(User user) {
        if (!loginIsValid(user.getLogin())) {
            return false;
        }

        if (!emailIsValid(user.getEmail())) {
            return false;
        }

        if (userService.exist(user)) {
            setErrorMessage(ConsoleColors.RED + "User with the same username or email already exists" +
                    ConsoleColors.RESET);
            return true;
        }

        if (!passwordIsValid(user.getPassword())) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isValidValueForField(String value, String field) {
        switch (field) {
            case "login":
                return loginIsValid(value);
            case "email":
                return emailIsValid(value);
            case "password":
                return passwordIsValid(value);
            default:
                System.out.println(ConsoleColors.RED + "There isn't validator for field" + field +
                        ConsoleColors.RESET);
                return false;
        }
    }

    public boolean loginIsValid(String login) {
        if (isEmptyField(login)) {
            changeErrorMessageForFieldToNewOne("Login", EMPTY_FIELD_ERROR_MESSAGE);
            return false;
        }

        if (!fieldIsInRequiredFormat(login, CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Login", CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    public boolean emailIsValid(String email) {
        if (isEmptyField(email)) {
            changeErrorMessageForFieldToNewOne("Email", EMPTY_FIELD_ERROR_MESSAGE);
            return false;
        }

        if (!fieldIsInRequiredFormat(email, EMAIL_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Email", EMAIL_FORMAT_ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    public boolean passwordIsValid(String password) {
        if (isEmptyField(password)) {
            changeErrorMessageForFieldToNewOne("Password", EMPTY_FIELD_ERROR_MESSAGE);
            return false;
        }

        if (!isLengthValueBetween(password, MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH)) {
            changeErrorMessageForFieldToNewOne("Password", PASSWORD_LENGTH_ERROR_MESSAGE);
            return false;
        }

        return true;
    }

}
