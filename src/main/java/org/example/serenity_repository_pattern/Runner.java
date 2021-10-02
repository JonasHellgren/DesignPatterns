package org.example.serenity_repository_pattern;

import java.util.List;


/***
 * https://github.com/JAVA-MSDT/repository-design-pattern/blob/master/src/main/java/com/serenity/repository/runner/Runner.java
 */

public class Runner {
    public static void main(String[] args) {

        PersonRepository repository = new PersonRepository();
        Person person1 = new Person(1, "Person1", 24, "city", "email", "job", Gender.MALE, false);
        Person person2 = new Person(2, "Person2", 22, "city2", "email2", "job2", Gender.FEMALE, true);
        Person person3 = new Person(3, "Person3", 20, "city3", "email3", "job3", Gender.MALE, true);
        Person person4 = new Person(4, "Person4", 18, "city4", "email4", "job4", Gender.FEMALE, false);
        Person person5 = new Person(5, "Person5", 50, "city5", "email5", "job5", Gender.MALE, true);
        Person person6 = new Person(6, "Person6", 34, "city6", "email6", "job6", Gender.FEMALE, false);

        // Adding Person to the storage
        repository.add(person1);
        repository.add(person2);
        repository.add(person3);
        repository.add(person4);
        repository.add(person5);
        repository.add(person6);

        // Getting Person list from the storage
        System.out.println("=================== Getting Person list from the storage ===================");

        for (Person p : repository.getAll()) {
            System.out.println(p);
        }
        System.out.println("===================");
        // FindByPersonName Specification
        System.out.println("=================== FindByPersonName Specification ===================");

        String name = "Person4";
        List<Person> findByPersonName = repository.findBySpecification(new FindByPersonName(name));
        for (Person p : findByPersonName) {
            System.out.println(p);
        }

        System.out.println("===================");
        // FindByPersonId Specification
        System.out.println("=================== FindByPersonId Specification ===================");

        int id = 2;
        List<Person> findByPersonId = repository.findBySpecification(new FindByPersonId(id));
        for (Person p : findByPersonId) {
            System.out.println(p);
        }

        /* You can check the Person class then creating a specification search as FindByPersonId
        and FindByPersonName in the repository package
        */

        System.out.println("===================");
        // Update Old Person with a new one
        System.out.println("=================== Update Old Person with a new one ===================");

        Person person7 = new Person(7, "Person7", 48, "city6", "email6", "job6", Gender.FEMALE, false);
        repository.update(person6, person7);
        int indexOfUpdatedObject = PersonStorage.getInstance().getPersonList().indexOf(person7);
        System.out.println(PersonStorage.getInstance().getPersonList().get(indexOfUpdatedObject));

        System.out.println(indexOfUpdatedObject);

        System.out.println("===================");
        // remove Person from the list
        System.out.println("=================== remove Person from the list ===================");
        repository.remove(id);
        List<Person> personListAfterRemovingPerson = repository.getAll();

        for (Person p : personListAfterRemovingPerson) {
            System.out.println(p);
        }
    }
}
