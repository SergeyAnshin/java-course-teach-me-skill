package concole.impl;

import concole.ConsoleEntityManager;
import entities.User;
import services.EntityService;
import services.impl.UserServiceImpl;
import validators.UserValidator;

public class ConsoleUserManagerImpl extends AbstractConsoleEntityManager<User> implements ConsoleEntityManager<User> {
    private EntityService<User> entityService = new UserServiceImpl();

    public ConsoleUserManagerImpl() {
        super(new UserValidator());
    }

    @Override
    public User getEntity() {
        String login = getStringValueForFieldFromConsole("login");
        String email = getStringValueForFieldFromConsole("email");
        String password = getStringValueForFieldFromConsole("password");
        return new User(login, email, password);
    }

}
