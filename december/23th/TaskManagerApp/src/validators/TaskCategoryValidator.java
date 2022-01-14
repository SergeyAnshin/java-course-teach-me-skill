package validators;

import concole.ConsoleColors;
import entities.Task;
import entities.TaskCategory;

import java.util.List;

public class TaskCategoryValidator extends AbstractValidator<TaskCategory> {
    private static final List<String> DEFAULT_NAME = List.of("To do", "In progress","Done");
    private static final String CATEGORY_WITH_NAME_ALREADY_EXIST_ERROR = "category with the same name already exists!";

    @Override
    public boolean isValid(TaskCategory taskCategory) {
        return nameIsValid(taskCategory.getName());
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

        if (DEFAULT_NAME.contains(name)) {
            changeErrorMessageForFieldToNewOne("Name", CATEGORY_WITH_NAME_ALREADY_EXIST_ERROR);
            return false;
        }

        return true;
    }
}
