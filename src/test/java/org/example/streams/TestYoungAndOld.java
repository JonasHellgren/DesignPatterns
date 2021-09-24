package org.example.streams;

import org.example.streams_needed_classes.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class TestYoungAndOld {

    List<Person> persons = new ArrayList<>();  //create list
    final Person jonash = new Person("Jonas Hellgren", 47);     final Person ch = new Person("Christofer Hellgren", 17);
    final Person alexh = new Person("Alexander Hellgren", 1);

    @Before
    public void arrange() {
        persons.add(jonash); persons.add(ch);  persons.add(alexh);  //put items in list
    }

    @Test
    public void Predicate() {
        Predicate<Person> ischild = person -> person.getAge()<14;  //lambda expression
        System.out.println("Is Jonas a child: "+ischild.test(jonash));  //test using above defined predicate ischild
        System.out.println("Is Christofer a child: "+ischild.test(ch));
        System.out.println("Is Alexander a child: "+ischild.test(alexh));

        Assert.assertFalse(ischild.test(jonash));
        Assert.assertFalse(ischild.test(ch));
        Assert.assertTrue(ischild.test(alexh));
    }

    @Test
    public void partitioningBy1() {
        //create map splitting into true and false groups, assign names for every group.
        Map<Boolean,List<Person>> oldAndYoungPersons1 = persons.stream()
                .collect(partitioningBy(person -> person.getAge()<14));
        System.out.println(oldAndYoungPersons1);
    }


    @Test
    public void partitioningBy2() {
        Map<Boolean,Long> oldAndYoungPersons2 = persons.stream()  //note: List changed to Long
                .collect(partitioningBy(person -> person.getAge()<14,counting()));
        System.out.println(oldAndYoungPersons2);
    }



}
