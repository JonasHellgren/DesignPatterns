package org.example.dao_pattern_baeldung;

public class UserRunner {
    public static void main(String[] args) {
        UserStorage userStorage=new UserStorage();
        userStorage.save(new User("John", "john@domain.com"));
        userStorage.save(new User("Susan", "susan@domain.com"));
        userStorage.getAll().forEach(System.out::println);

        userStorage.update("John",new User("Alex", "alex@domain.com"));
        System.out.println("After update");
        userStorage.getAll().forEach(System.out::println);


    }
}
