package org.anshin.validators;

import org.anshin.enums.Operation;

import static org.anshin.enums.ValidatorMessage.*;

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
        if (number == null && number.isBlank()) {
            changeErrorMessageForFieldToNewOne("Value", EMPTY_FIELD_ERROR_MESSAGE.getMessage());
            return false;
        }

        if (!valueIsInRequiredFormat(number, NUMBER_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Value", CONTAIN_ONLY_NUMBERS_MESSAGE.getMessage());
            return false;
        }

        return true;
    }

    public boolean isOperationParameterValid(String operation) {
        if (operation == null && operation.isBlank()) {
            changeErrorMessageForFieldToNewOne("Operation", EMPTY_FIELD_ERROR_MESSAGE.getMessage());
            return false;
        }

        if (!Operation.contain(operation)) {
            changeErrorMessageForFieldToNewOne("Operation", OPERATION_DOES_NOT_EXIST_MESSAGE.getMessage());
            return false;
        }

        return true;
    }

}
