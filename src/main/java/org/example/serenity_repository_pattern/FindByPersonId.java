package org.example.serenity_repository_pattern;

public class FindByPersonId implements SpecificationInterface<Person> {

    private final long userId;    //the id to look for

    public FindByPersonId(long userId) {
        this.userId = userId;
    }


    @Override
    public boolean isExist(Person person) {
        return person.id == userId;
    }
}
