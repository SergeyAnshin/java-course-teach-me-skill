package services.impl;

import entities.User;
import repositories.UserRepository;
import repositories.impl.UserRepositoryImpl;
import services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService<User> {
    private final UserRepository<User> repository = new UserRepositoryImpl();

    @Override
    public void save(User user) {
        if (user != null && !exist(user)) {
            repository.save(user);
        } else {
            System.out.println("User already exist or null");
        }
    }

    @Override
    public boolean exist(User user) {
        if (user != null) {
            return repository.exist(user);
        }
        return true;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
