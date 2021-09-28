package org.example.dao_pattern_baeldung;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserStorage implements StorageInterface<User> {

    private final List<User> users = new ArrayList<>();

    public UserStorage() {

    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(String userName, User replacingUser) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).name.equals(userName)) {
                users.set(i, replacingUser);
                return;
            }
        }

        System.out.println("Warning: user not found");

    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}