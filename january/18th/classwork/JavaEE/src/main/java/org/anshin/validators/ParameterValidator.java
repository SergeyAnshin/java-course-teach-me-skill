package org.anshin.validators;

import org.anshin.enums.Operation;

public class ParameterValidator extends AbstractValidator {

    @Override
    public boolean isValidValueForField(String value, String field) {
        switch (field) {
            case "number" :
                return isNumericParameterValid(value);
            case "operation" :
                return isOperationParameterValid(value);
            default:
                return false;
        }
    }

    public boolean isNumericParameterValid(String number) {
        return number != null
                && !number.isBlank()
                && valueIsInRequiredFormat(number, NUMBER_FORMAT);
    }

    public boolean isOperationParameterValid(String operation) {
        return operation != null
                && !operation.isBlank()
                && Operation.contain(operation);
    }

}
