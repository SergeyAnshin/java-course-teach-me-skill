package services;

import entities.users.User;

import java.util.Scanner;
import java.util.function.Predicate;

public class UserServiceImpl implements UserService {
    private StorageService<User> storageService;

    public UserServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void signUp() {
        System.out.println("SIGN UP");
        User user = getUserData();
        if (!storageService.contains(user)) {
            storageService.addInStorage(user);
        } else {
            System.out.println("Login already exists");
        }
    }

    @Override
    public boolean login() {
        System.out.println("LOG IN");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        return storageService.getAllStorage()
                .stream()
                .noneMatch(user -> user.getLogin().equals(login) && user.getLogin().equals(password));
    }

    private User getUserData() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.print("Name: ");
        user.setName(scanner.nextLine());
        System.out.print("Login: ");
        user.setLogin(scanner.nextLine());
        System.out.print("Password: ");
        user.setPassword(scanner.nextLine());
        return user;
    }
}
