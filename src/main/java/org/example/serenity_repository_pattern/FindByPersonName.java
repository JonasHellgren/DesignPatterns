package org.example.serenity_repository_pattern;

public class FindByPersonName implements SpecificationInterface<Person> {

    private final String name;  //the name to look for

    public FindByPersonName(String name) {
        this.name = name;
    }

    @Override
    public boolean isExist(Person person) {
        return person.name.equalsIgnoreCase(name);
    }
}