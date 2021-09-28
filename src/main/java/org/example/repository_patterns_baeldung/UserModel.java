package org.example.repository_patterns_baeldung;

public class UserModel {

    public String name;
    public String email;

    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
