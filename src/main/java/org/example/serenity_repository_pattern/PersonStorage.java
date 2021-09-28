package org.example.serenity_repository_pattern;

import java.util.ArrayList;
import java.util.List;

public class PersonStorage {
    private List<Person> personList;

    private static PersonStorage instance = new PersonStorage();


    private PersonStorage() {
        personList = new ArrayList<>();
    }

    public static PersonStorage getInstance() {
        return instance;
    }

    public PersonStorage(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

}