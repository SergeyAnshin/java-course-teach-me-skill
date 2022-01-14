package validators;

import concole.ConsoleColors;
import entities.Task;

public class TaskValidator extends AbstractValidator<Task> {

    @Override
    public boolean isValid(Task task) {
        return nameIsValid(task.getName());
    }

    @Override
    public boolean isValidValueForField(String value, String field) {
        if ("name".equals(field)) {
            return nameIsValid(value);
        }
        System.out.println(ConsoleColors.RED + "There isn't validator for field" + field + ConsoleColors.RESET);
        return false;
    }

    private boolean nameIsValid(String name) {
        if (isEmptyField(name)) {
            changeErrorMessageForFieldToNewOne("Name", EMPTY_FIELD_ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
