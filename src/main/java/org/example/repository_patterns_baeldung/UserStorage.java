package org.example.repository_patterns_baeldung;


import org.example.dao_pattern_baeldung.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage implements UserStorageInterface {
    private final List<UserModel> users = new ArrayList<>();


    @Override
    public void create(UserModel user) {
        users.add(user);
    }

    @Override
    public UserModel read(int id) {
        return users.get(id);
    }

    @Override
    public void delete(String userName) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).name.equals(userName)) {
                users.remove(i);
                return;
            }
        }

        System.out.println("Warning: user not found");
    }

    public UserModel findUser(String name) {

        for (UserModel user:users) {
            if (user.name.equals(name))
                return user;
        }
        System.out.println("User not found");
        return null;
    }

}
