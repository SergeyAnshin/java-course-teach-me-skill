package org.anshin.validators;

import org.anshin.enums.Operation;

import java.util.regex.Pattern;

public class ParameterValidator {
    public static final String NUMBER_FORMAT = "^[-+]?\\d*[.,]?\\d+(?:[eE][-+]?\\d+)?$";

    public static boolean isNumericParameterValid(String number) {
        return number != null
                && !number.isBlank()
                && parameterIsInRequiredFormat(number, NUMBER_FORMAT);
    }

    public static boolean isOperationParameterValid(String operation) {
        return operation != null
                && !operation.isBlank()
                && Operation.contain(operation);
    }

    public static boolean parameterIsInRequiredFormat(String parameter, String format) {
        return Pattern.compile(format).matcher(parameter).find();
    }
}
