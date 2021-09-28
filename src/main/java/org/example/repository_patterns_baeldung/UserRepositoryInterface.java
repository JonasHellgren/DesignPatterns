package org.example.repository_patterns_baeldung;

public interface UserRepositoryInterface {
    UserModel get(int id);
    void add(UserModel user);
    //void update(User user);
    void remove(UserModel user);
}



