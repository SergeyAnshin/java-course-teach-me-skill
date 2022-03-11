package org.anshin.validator;

import org.anshin.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    private static UserValidator userValidator;
    private static User user;

    @BeforeAll
    static void init() {
        userValidator = new UserValidator();
    }

    @Test
    void isValidValueForField() {
        assertTrue(userValidator.isValidValueForField("email@email.com", UserValidator.FIELD_NAME_EMAIL));
        assertTrue(userValidator.isValidValueForField("login", UserValidator.FIELD_NAME_LOGIN));
        assertTrue(userValidator.isValidValueForField("password", UserValidator.FIELD_NAME_PASSWORD));
        assertTrue(userValidator.isValidValueForField("keyword", UserValidator.FIELD_NAME_KEYWORD));

        assertFalse(userValidator.isValidValueForField("value", "notExistField"));
    }

    @Test
    void emailIsValid() {
        assertTrue(userValidator.emailIsValid("e@e.c"));
        assertTrue(userValidator.emailIsValid("email@emai.com"));
        assertTrue(userValidator.emailIsValid("email@emai.ru"));
        assertTrue(userValidator.emailIsValid("email123@email.com"));
        assertTrue(userValidator.emailIsValid("email_123@email.com"));
        assertTrue(userValidator.emailIsValid("email_email@email.com"));

        assertFalse(userValidator.emailIsValid(null));
        assertFalse(userValidator.emailIsValid(""));
        assertFalse(userValidator.emailIsValid(" "));
        assertFalse(userValidator.emailIsValid("@."));
    }

    @Test
    void loginIsValid() {
        assertTrue(userValidator.loginIsValid("login"));
        assertTrue(userValidator.loginIsValid("LOGIN"));
        assertTrue(userValidator.loginIsValid("LoGiN"));
        assertTrue(userValidator.loginIsValid("login123"));

        assertFalse(userValidator.loginIsValid(null));
        assertFalse(userValidator.loginIsValid(""));
        assertFalse(userValidator.loginIsValid(" "));
        assertFalse(userValidator.loginIsValid("логин"));
        assertFalse(userValidator.loginIsValid("логин123"));
    }

    @Test
    void passwordIsValid() {
        assertTrue(userValidator.passwordIsValid("login"));
        assertTrue(userValidator.passwordIsValid("логин"));
        assertTrue(userValidator.passwordIsValid("login*/-8_32498+/.,,,"));

        assertFalse(userValidator.passwordIsValid(null));
        assertFalse(userValidator.passwordIsValid(""));
        assertFalse(userValidator.passwordIsValid(" "));
        assertFalse(userValidator.passwordIsValid("логи"));
        assertFalse(userValidator.passwordIsValid("logi"));
        assertFalse(userValidator.passwordIsValid("logikfjsnkjdkfjdsnksjdnkdjnksjdnkdsnkfjs"));
    }
}