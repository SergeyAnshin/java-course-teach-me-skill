package concole.impl;

import concole.ConsoleEntityManager;
import entities.Project;
import validators.ProjectValidator;

public class ConsoleProjectManagerImpl extends AbstractConsoleEntityManager<Project> implements ConsoleEntityManager<Project>  {

    public ConsoleProjectManagerImpl() {
        super(new ProjectValidator());
    }

    @Override
    public Project getEntity() {
        String name = getStringValueForFieldFromConsole("name");
        String key = getStringValueForFieldFromConsole("key");
        return new Project(name, key);
    }
}
