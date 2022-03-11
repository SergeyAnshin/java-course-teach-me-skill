package org.anshin.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterValidatorTest {
    private static ParameterValidator parameterValidator;

    @BeforeAll
    static void init() {
        parameterValidator = new ParameterValidator();
    }

    @Test
    void isValidValueForField() {
        assertFalse(parameterValidator.isValidValueForField("SUM", "notExistField"));

        assertTrue(parameterValidator.isValidValueForField("1", ParameterValidator.FIELD_NAME_NUMBER));
        assertFalse(parameterValidator.isValidValueForField("SUM", ParameterValidator.FIELD_NAME_NUMBER));

        assertTrue(parameterValidator.isValidValueForField("SUM", ParameterValidator.FIELD_NAME_OPERATION));
        assertFalse(parameterValidator.isValidValueForField("notExistOperation", ParameterValidator.FIELD_NAME_NUMBER));

    }

    @Test
    void isNumericParameterValid() {
        assertTrue(parameterValidator.isNumericParameterValid("1"));
        assertTrue(parameterValidator.isNumericParameterValid("1.0"));
        assertTrue(parameterValidator.isNumericParameterValid("1,0"));
        assertTrue(parameterValidator.isNumericParameterValid("+1.0"));
        assertTrue(parameterValidator.isNumericParameterValid("-1.0"));
        assertTrue(parameterValidator.isNumericParameterValid("12345.1234"));
        assertTrue(parameterValidator.isNumericParameterValid("0.1234"));

        assertFalse(parameterValidator.isNumericParameterValid(""));
        assertFalse(parameterValidator.isNumericParameterValid(" "));
        assertFalse(parameterValidator.isNumericParameterValid(null));
        assertFalse(parameterValidator.isNumericParameterValid("sama"));
    }

    @Test
    void isOperationParameterValid() {
        assertTrue(parameterValidator.isOperationParameterValid("SUM"));
        assertTrue(parameterValidator.isOperationParameterValid("SUBTRACT"));

        assertFalse(parameterValidator.isOperationParameterValid(""));
        assertFalse(parameterValidator.isOperationParameterValid(" "));
        assertFalse(parameterValidator.isOperationParameterValid(null));
        assertFalse(parameterValidator.isOperationParameterValid("sama"));
    }
}