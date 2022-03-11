package org.anshin.dao.impl.collectionstorage;

import org.anshin.entity.User;
import org.anshin.enums.Role;
import org.anshin.dao.UserDAO;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserHashMapDAO implements UserDAO {
    private final Map<String, User> userStorage = new ConcurrentHashMap<>();

    public UserHashMapDAO() {
        User admin = new User("admin@gmail.com","admin", "admin", Role.ADMIN);
        userStorage.putIfAbsent("admin", admin);
    }

    @Override
    public boolean exists(User user) {
        if (!userStorage.isEmpty()) {
            User userFromStorage = userStorage.get(user.getLogin());
            return userFromStorage != null && user.getEmail().equals(userFromStorage.getEmail());
        } else {
            return false;
        }
    }

    @Override
    public boolean existsByEmailAndLogin(String email, String login) {
        if (userStorage.isEmpty()) {
            return false;
        } else {
            return userStorage.containsKey(login) || userStorage.values()
                    .stream()
                    .map(User::getEmail)
                    .anyMatch(Predicate.isEqual(email));
        }
    }

    @Override
    public boolean save(User user) {
        return userStorage.putIfAbsent(user.getLogin(), user) == null;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return !userStorage.isEmpty() ? Optional.ofNullable(userStorage.get(login)) : Optional.empty();
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        if (!userStorage.isEmpty()) {
            User user = userStorage.get(login);
            if (user != null) {
                return user.getPassword().equals(password) ? Optional.of(user) : Optional.empty();
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return userStorage.values()
                .stream()
                .filter(user -> user.getRole() != Role.ADMIN).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        return userStorage.values().removeIf(user ->  user.getId() == id);
    }

    @Override
    public List<User> findAllFromIdWithLimit(long id, long limit) {
        SortedSet<User> users = new TreeSet<>(Comparator.comparing(User::getLogin));
        users.addAll(userStorage.values());
        return users.stream().filter(user -> user.getId() >= id).limit(limit).collect(Collectors.toList());
    }

    @Override
    public boolean updatePasswordForUserWithEmail(String newPassword, String email) {
        User userFromStorage = userStorage.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
        if (userFromStorage != null) {
            userFromStorage.setPassword(newPassword);
            return userStorage.put(userFromStorage.getLogin(),  userFromStorage) != null;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsByEmailAndKeyword(String email, String keyword) {
        if (userStorage == null || userStorage.isEmpty()) {
            return false;
        } else {
            return userStorage.values()
                    .stream()
                    .anyMatch(user -> user.getEmail().equals(email)
                            && (user.getKeyword() != null && user.getKeyword().equals(keyword)));
        }
    }

    @Override
    public boolean update(User user) {
        return userStorage != null && !userStorage.isEmpty() && userStorage.put(user.getLogin(), user) != null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userStorage.values().stream().filter(user -> user.getId() == id).findFirst();
    }
}
