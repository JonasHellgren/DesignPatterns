package org.example.repository_patterns_baeldung;

public interface  UserStorageInterface {
    void create(UserModel user);
    UserModel read(int id);
    //void update(User user);
    void delete(String userName);
}
