package org.example.interface_tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionInterface {

    Function<Integer, Integer> inc = e -> e + 1;

    public static int doSum(int value, Function<Integer, Integer> func) {
        return func.apply(value);
    }

    Consumer<Integer> soutRef1 = s -> System.out.println(s);
    Consumer<Integer> soutRef2 = System.out::println;

    public static boolean isMoreThan5(int n1) {
        return n1 > 5;
    }

    public static List<Integer> findNumbers(
            List<Integer> l, Predicate<Integer> p) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : l) {
            if (p.test(i)) {
                newList.add(i);
            }
        }
        return newList;
    }

    @FunctionalInterface
    interface Sayable {
        void say(String msg);
    }

    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

    @Test
    public void addOneTo5() {
        System.out.println(doSum(5, inc));
    }

    @Test
    public void soutRef1() {
        numbers.forEach(soutRef1);
    }

    @Test
    public void soutRef2() {
        numbers.forEach(soutRef2);
    }

    @Test
    public void morethan5() {
        //pass isMoreThan5 into findNumbers
        List<Integer> foundNumbers = findNumbers(numbers, (i1) -> isMoreThan5(i1));
        foundNumbers.forEach(soutRef1);
    }

    @Test
    public void morethan5again() {
        //pass isMoreThan5 into findNumbers
        Predicate<Integer> btf = n -> n > 5;
        List<Integer> foundNumbers = findNumbers(numbers, btf);
        foundNumbers.forEach(soutRef1);
    }

    @Test
    public void morethan5WithStream() {
        //pass isMoreThan5 into findNumbers
        Predicate<Integer> btf = n -> n > 5;
        List<Integer> foundNumbers = numbers.stream().filter(btf).collect(Collectors.toList());
        foundNumbers.forEach(soutRef1);
    }

    @Test
    public void sayable() {


         class PrintOneLine implements Sayable {
            public void say(String msg) {
                System.out.println(msg);
            }
        }

         class PrintTwoLines implements Sayable {
            public void say(String msg) {
                System.out.println(msg);
                System.out.println(msg);
            }
        }

        PrintOneLine fie1 = new PrintOneLine();
        fie1.say("Hello there");
        PrintTwoLines fie2 = new PrintTwoLines();
        fie2.say("Hello there again");
    }

}
