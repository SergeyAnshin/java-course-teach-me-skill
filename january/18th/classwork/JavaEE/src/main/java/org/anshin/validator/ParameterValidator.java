package org.anshin.validator;

import org.anshin.enums.Operation;

import static org.anshin.validator.ValidatorMessageConstant.*;

public class ParameterValidator extends AbstractValidator {
    public static final String FIELD_NAME_NUMBER = "number";
    public static final String FIELD_NAME_OPERATION = "operation";

    @Override
    public boolean isValidValueForField(String value, String field) {
        switch (field) {
            case FIELD_NAME_NUMBER:
                return isNumericParameterValid(value);
            case FIELD_NAME_OPERATION:
                return isOperationParameterValid(value);
            default:
                return false;
        }
    }

    public boolean isNumericParameterValid(String number) {
        if (number == null || number.isBlank()) {
            changeErrorMessageForFieldToNewOne("Value", ERROR_MESSAGE_EMPTY_FIELD);
            return false;
        }

        if (!valueIsInRequiredFormat(number, NUMBER_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Value", ERROR_MESSAGE_MUST_CONTAIN_ONLY_NUMBERS);
            return false;
        }

        return true;
    }

    public boolean isOperationParameterValid(String operation) {
        if (operation == null || operation.isBlank()) {
            changeErrorMessageForFieldToNewOne("Operation", ERROR_MESSAGE_EMPTY_FIELD);
            return false;
        }

        if (!Operation.contain(operation)) {
            changeErrorMessageForFieldToNewOne("Operation", ERROR_MESSAGE_OPERATION_DOES_NOT_EXIST);
            return false;
        }

        return true;
    }

}
