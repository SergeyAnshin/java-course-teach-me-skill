package validators;

import concole.ConsoleColors;
import entities.Project;
import services.ProjectService;
import services.impl.ProjectServiceImpl;

public class ProjectValidator extends AbstractValidator<Project> {
    private ProjectService<Project> projectService = new ProjectServiceImpl();

    @Override
    public boolean isValid(Project project) {
        if (!nameIsValid(project.getName())) return false;

        if (projectService.exist(project)) {
            return false;
        }

        return keyIsValid(project.getKey());
    }

    @Override
    public boolean isValidValueForField(String value, String field) {
        switch (field) {
            case "name":
                return nameIsValid(value);
            case "key":
                return keyIsValid(value);
            default:
                System.out.println(ConsoleColors.RED + "There isn't validator for field" + field + ConsoleColors.RESET);
                return false;
        }
    }

    public boolean nameIsValid(String name) {
        if (isEmptyField(name)) {
            changeErrorMessageForFieldToNewOne("Name", EMPTY_FIELD_ERROR_MESSAGE);
            return false;
        }

        if (!fieldIsInRequiredFormat(name, CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Name", CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public boolean keyIsValid(String key) {
        if (isEmptyField(key)) {
            changeErrorMessageForFieldToNewOne("Key", EMPTY_FIELD_ERROR_MESSAGE);
            return false;
        }

        if (!fieldIsInRequiredFormat(key, CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_FORMAT)) {
            changeErrorMessageForFieldToNewOne("Key", CONTAIN_ONLY_LATIN_LETTERS_AND_NUMBERS_ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
