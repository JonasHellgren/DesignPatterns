package org.example.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTestPerson {

    public enum Gender  {MALE, FEMALE};

    @Getter
    @AllArgsConstructor
    @ToString
    public class Person {
        private String name;
        private int age;
        private Gender gender;
    }

    List<Person> persons;

    @Before
    public void arrange() {

        persons=List.of(
                new Person("James Bond",55, Gender.MALE),
                new Person("Mamma Mu",33, Gender.FEMALE),
                new Person("Nelson Mandela",95, Gender.MALE),
                new Person("Barak Obama",55, Gender.MALE)
       );

    }

    @Test
    public void extractFemales() {
        //filter, sort out females according to predicate
        List<Person> females=
                persons.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());

        females.forEach(System.out::println);

        Assert.assertTrue(females.get(0).getGender()== Gender.FEMALE);
    }

    @Test
    public void sortByAge() {
        //sorted
        List<Person> sorted=
                persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());

        sorted.forEach(System.out::println);
        Assert.assertTrue(sorted.get(0).getAge()==33);
    }

    @Test
    public void allMatch() {
        //allMatch
        boolean allAdult=
                persons.stream().allMatch(p -> p.getAge()>18);
        Assert.assertTrue(allAdult);
    }

    @Test
    public void anyMatch() {
        //anyMatch
        boolean allOld=
                persons.stream().anyMatch(p -> p.getAge()>55);
        Assert.assertTrue(allOld);
    }

    @Test
    public void noneMatch() {
        //noneMatch
        boolean noJonas=
                persons.stream().noneMatch(p -> p.getName()=="Jonas");
        Assert.assertTrue(noJonas);
    }

    @Test
    public void oldestPerson() {
        //max
        persons.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
        Person oldest=
                persons.stream().max(Comparator.comparing(Person::getAge)).get();
        Assert.assertTrue(oldest.getAge()==95);
    }

    @Test
    public void groupGender() {
        Map<Gender,List<Person>> groupByGender=persons.stream().collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender,p)  -> {
            System.out.println(gender);
            p.forEach(System.out::println);
            System.out.println();
        }
    );
    }

    @Test
    public void oldestMale() {
        //filter, max

        Person oldestMale=
                persons.stream().
                filter(p -> p.getGender().equals(Gender.MALE)).
                max(Comparator.comparing(Person::getAge)).
                get();

        System.out.println(oldestMale);
        Assert.assertTrue(oldestMale.getName().equals("Nelson Mandela"));
    }

}
