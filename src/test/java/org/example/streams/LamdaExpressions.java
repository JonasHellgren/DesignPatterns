package org.example.streams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class LamdaExpressions {

    final static Logger logger = Logger.getLogger(LamdaExpressions.class.getName());

    List<String> strings;
    List<Integer> numbers;
    int a;
    int b;

    interface MathOperation {
        int operation(int a, int b);
    }

    MathOperation addition = (int a, int b) -> a + b;
    MathOperation subtraction = (a, b) -> a - b;

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    class Product {
        String name;
        float price;

        public Product(String name, float price) {
            this.name = name;
            this.price = price;
        }
    }

    @Before
    public void arrange() {
        strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        a = 1;
        b = 1;
    }

    @Test
    public void forEach() {
        //‘forEach’ iterates each element of the stream
        numbers.forEach((n) -> System.out.println(n));
    }

    @Test
    public void forEachConsumer() {
        //Consumer accepts a single input argument and returns no result
        Consumer<Integer> method = System.out::println;
        numbers.forEach(method);
    }

    @Test
    public void addition() {
        //send a function as parameter, use interface MathOperation
        System.out.println("addition of " + a + " and " + b + " gives:" + operate(1, 1, addition));
        Assert.assertTrue(operate(1, 1, addition)==2);
    }

    @Test
    public void subtraction() {
        System.out.println("subtraction of " + a + " and " + b + " gives:" + operate(1, 1, subtraction));
        Assert.assertTrue(operate(1, 1, subtraction)==0);
    }

    @Test
    public void namesMap() {
        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");
        namesMap.forEach((key, value) -> System.out.println(key + " " + value));
    }

    @Test
    public void numbersSort() {
        //java.util.Collections.sort() method is present in java.util.Collections class. It is used to sort
        // the elements present in the specified list of Collection in ascending order.

        Collections.sort(numbers);  //same as   numbers.sort(Comparator.comparing(n -> n));
        numbers.forEach((n) -> {
            System.out.println(n);
        });

        Assert.assertEquals(numbers.get(0),2,0.1);
    }

    @Test
    public void priceSort() {
        List<Product> list = new ArrayList<>();
        //Adding Products
        list.add(new Product("HP Laptop", 25000f));
        list.add(new Product("Keyboard", 300f));
        list.add(new Product("Dell Mouse", 150f));

        list.sort(Comparator.comparing(p -> p.price));

        list.forEach((n) -> {
            System.out.println(n.name + " " + n.price);
        });
    }


}
