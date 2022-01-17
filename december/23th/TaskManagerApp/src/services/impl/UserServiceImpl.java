package services.impl;

import entities.User;
import repositories.UserRepository;
import repositories.impl.UserRepositoryImpl;
import services.UserService;

public class UserServiceImpl extends AbstractEntityServiceImpl<User> implements UserService<User> {
    private UserRepository<User> userRepository = new UserRepositoryImpl();

    public UserServiceImpl() {
        super(new UserRepositoryImpl());
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
